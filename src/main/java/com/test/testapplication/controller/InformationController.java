package com.test.testapplication.controller;

import com.test.testapplication.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InformationController {

    @Autowired
    private InformationService informationService;

    @GetMapping("/information")
    public ResponseEntity<InfoDetailsDTO> handleInformation(
            @RequestParam() String country,
            @RequestParam() String description) {

        InfoDetailsDTO infoDetails = informationService.getInformation(country, description);

        ResponseEntity<InfoDetailsDTO> responseEntity = new ResponseEntity<InfoDetailsDTO>(infoDetails, HttpStatus.OK);
        return responseEntity;
    }
}
