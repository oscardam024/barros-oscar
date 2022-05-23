package com.example.backoscar.ogarcia.service;

import com.example.backoscar.ogarcia.exception.FileStorageException;
import com.example.backoscar.ogarcia.model.Archivo;
import com.example.backoscar.ogarcia.propiedades.FileStoragesProperties;
import com.example.backoscar.ogarcia.repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ArchivoService extends BaseService<Archivo,Integer, ArchivoRepository>{

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    FileStoragesProperties fileStorageProperties;

    public Archivo addArvhivo(MultipartFile data){
        String ruta = storeFile(data);
        Archivo archivo = new Archivo();

        archivo.setRuta(ruta);

        return archivoRepository.save(archivo);
    }

    public Archivo findArchivoById(Integer id){
        Archivo archivoEntity=archivoRepository.findById(id).get();

        return archivoEntity;
        //.orElseThrow(()-> new ArchivoNotFoundException("Archivo con id :"+id+" no funciona"));

    }


    public String storeFile(MultipartFile file) {

        Path fileStorageLocation =
                Paths.get(this.fileStorageProperties.getUploadDir())
                        .toAbsolutePath().normalize();

// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
// Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

// Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);
            return fileStorageLocation.toString().concat("/").concat(fileName);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName +
                    ". Please try again!", ex);
        }
    }

    //ArchivoEntity pasar
    public Resource loadFileAsResource(String fileName) throws MalformedURLException {

        Path fileStorageLocation =
                Paths.get(this.fileStorageProperties.getUploadDir().concat("/").concat(fileName))
                        .toAbsolutePath().normalize();



        Resource resource = new UrlResource(fileStorageLocation.resolve(fileStorageLocation).toUri());
        return resource;
    }

}
