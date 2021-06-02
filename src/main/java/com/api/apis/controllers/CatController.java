package com.api.apis.controllers;

import com.api.apis.services.CatService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/cat")
public class CatController {

    CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping(value = "/img/{mod}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getCatImg(@PathVariable String mod) {
        try{
            ByteArrayResource imageBytes = catService.getImg(mod);
            return ResponseEntity.status(HttpStatus.OK).contentLength(imageBytes.contentLength()).body(imageBytes);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/happy/{mod}", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<Resource> getSad(@PathVariable String mod) {
        try {
            ByteArrayResource imageBytes = catService.getGif(mod);
            return ResponseEntity.status(HttpStatus.OK).contentLength(imageBytes.contentLength()).body(imageBytes);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
