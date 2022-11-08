package com.pavucs.globelibraryservice.controller;

import com.pavucs.globelibraryservice.service.GlobleLibraryService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobleLibraryController {

    @Autowired
    GlobleLibraryService globleLibraryService;

    @GetMapping(path = "/globe/book")
    public ResponseEntity<Object> getBooks(){
        return globleLibraryService.getBooks();
    }

}
