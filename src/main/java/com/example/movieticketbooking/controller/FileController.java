package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.FileUploadResponse;
import com.example.movieticketbooking.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${host.name}")
    private String hostname;

    @Value("${root.fileImgMovie.path}")
    private String rootPathImgMovie;

    @Value("${root.fileImgUser.path}")
    private String rootPathImgUser;

    @PostMapping("/upload/movie")
    public ResponseEntity<FileUploadResponse> uploadFileImgMovie(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String uploadFileName = FileUploadUtils.saveFile(fileName, multipartFile, rootPathImgMovie);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(uploadFileName);
        response.setSize(size);
        response.setDownloadUri(hostname + "/download/movie" + uploadFileName);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/upload/user")
    public ResponseEntity<FileUploadResponse> uploadFileImgUser(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String uploadFileName = FileUploadUtils.saveFile(fileName, multipartFile, rootPathImgUser);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(uploadFileName);
        response.setSize(size);
        response.setDownloadUri(hostname + "/download/user" + uploadFileName);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/download/movie/{filename}")
    public ResponseEntity<?> downloadFileImgMoive(@PathVariable String filename) throws FileNotFoundException {
        try {
            Path path = Paths.get(rootPathImgMovie);
            Path pathFile = path.resolve(filename);
            Resource resource = new UrlResource(pathFile.toUri());

            if(resource.exists() || resource.isReadable()){
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                        .body(resource);
            } else{
                throw new FileNotFoundException("Không tìm thấy file");
//                        RuntimeException("Không tìm thấy file");
            }
        } catch (Exception e){
            throw new FileNotFoundException("Không tìm thấy file");
        }
    }

    @GetMapping("/download/user/{filename}")
    public ResponseEntity<?> downloadFileImgUser(@PathVariable String filename) throws FileNotFoundException {
        try {
            Path path = Paths.get(rootPathImgUser);
            Path pathFile = path.resolve(filename);
            Resource resource = new UrlResource(pathFile.toUri());

            if(resource.exists() || resource.isReadable()){
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                        .body(resource);
            } else{
                throw new FileNotFoundException("Không tìm thấy file");
//                        RuntimeException("Không tìm thấy file");
            }
        } catch (Exception e){
            throw new FileNotFoundException("Không tìm thấy file");
        }
    }
}
