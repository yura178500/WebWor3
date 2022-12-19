package ru.example.worwebapi.Controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.example.worwebapi.Services.FilesService;

import java.io.*;
import java.rmi.RemoteException;

@RestController
@RequestMapping("/files")
public class FilesController {
    private  final FilesService filesServices;

    public FilesController(FilesService filesServices) {
        this.filesServices = filesServices;
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = filesServices.getDataFile();
        if (file.exists()){
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\"Log.json\"")
                    .body(resource);

        }else{
            return ResponseEntity.noContent().build();

        }
    }
    @PostMapping(value = "/import",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void>uploadFile(@RequestParam MultipartFile file) throws IOException {
        filesServices.cleanDataFile();
        File dataFile = filesServices.getDataFile();
        try (BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
             FileOutputStream fos = new FileOutputStream(dataFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] buffer = new byte[1024];
            while (bis.read() > 0) {
                bos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }}
