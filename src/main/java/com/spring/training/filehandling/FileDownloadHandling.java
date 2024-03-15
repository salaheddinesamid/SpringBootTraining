package com.spring.training.filehandling;

import org.apache.coyote.Response;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

@RestController
public class FileDownloadHandling {
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException{
        String fileName = "/Users/mac/Desktop/Graphs.pdf";
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(
                new FileInputStream(file)
        );
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",String.format("attachment; fileName"));
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");
        ResponseEntity<Object> responseEntity =
                ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
        return responseEntity;

    }
}
