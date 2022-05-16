package com.example.backoscar.ogarcia.controller;


import com.example.backoscar.ogarcia.model.Archivo;
import com.example.backoscar.ogarcia.service.ArchivoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/archivos")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    @GetMapping(value = "/lista")
    public ResponseEntity<List<Archivo>> listaArchivos(){
        List<Archivo> archivos = null;
        archivos = archivoService.findAll();
        return new ResponseEntity<>(archivos, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Archivo> addArchivo( @RequestParam( "file")MultipartFile nombre){
        Archivo addArchivo= archivoService.addArvhivo(nombre);
        return new ResponseEntity<>(addArchivo,HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Archivo> findArchivoById(@PathVariable("id") Integer id){
        Archivo archivo = archivoService.findArchivoById(id);
        return new ResponseEntity<>(archivo, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName,
                                                 HttpServletRequest request) throws MalformedURLException {
// Load file as Resource
        Resource resource = archivoService.loadFileAsResource(fileName);
// Try to determine file's content type
        String contentType = null;
        try {
            contentType =
                    request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type.");
        }
// Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
