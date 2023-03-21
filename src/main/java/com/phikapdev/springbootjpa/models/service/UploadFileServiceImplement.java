package com.phikapdev.springbootjpa.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImplement implements IUploadFileService {

    private final static String UPLOADS_FOLDER = "uploads";

    @Override
    public Resource load(String filename) throws MalformedURLException{
        Path pathFoto = getPath(filename);
        Resource recurso = null;

        recurso = new UrlResource(pathFoto.toUri());
        if(!recurso.exists() && !recurso.isReadable()){
            throw new RuntimeException("Error no se puede cargar la imagen:" + pathFoto);
        }
        return recurso;
    }

    @Override
    public String copy(MultipartFile file)throws IOException {
        String uniqueFileName = UUID.randomUUID().toString() + " " + file.getOriginalFilename();
        Path rootPath = Paths.get(UPLOADS_FOLDER).resolve(uniqueFileName);
        
        Files.copy(file.getInputStream(), rootPath);
       
        return uniqueFileName;
    }

    @Override
    public boolean delete(String filename) {
        
        Path rooPath = getPath(filename);
        File archivo = rooPath.toFile();

        if(archivo.exists() && archivo.canRead()){
            if(archivo.delete()){
                return true;
            }
        }

        return false;
    }

    public Path getPath(String filename){
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
        
    }

    @Override
    public void deleteAll() {
       FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
        
    }

    @Override
    public void init() throws IOException {
       Files.createDirectories(Paths.get(UPLOADS_FOLDER));
    }
    
}
