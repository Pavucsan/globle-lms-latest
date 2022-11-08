package com.pavucs.globelibraryservice.service;

import com.pavucs.globelibraryservice.config.MicroserviceCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GlobleLibraryService {

    @Autowired
    MicroserviceCall microserviceCall;


    public ResponseEntity<Object> getBooks(){
        return microserviceCall.callService("/books/list");
    }
}
