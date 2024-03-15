package com.spring.training.filehandling;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file")MultipartFile file) throws IOException{
            File convertFile = new File("Users/mac/Desktop/" + file.getOriginalFilename());
            convertFile.createNewFile();
            FileOutputStream fp = new FileOutputStream(convertFile);
            fp.write(file.getBytes());
            fp.close();
            return "File is uploaded successfully";

    }
}
