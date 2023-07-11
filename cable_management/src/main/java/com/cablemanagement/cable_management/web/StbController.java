package com.cablemanagement.cable_management.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cablemanagement.cable_management.entity.Stb;
import com.cablemanagement.cable_management.service.StbService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/stb")
public class StbController {
    @Autowired
    StbService stbService;

    @PostMapping("{id}")
    public ResponseEntity<Stb> addCustomerStb(@PathVariable Long id,@RequestBody Stb stb) {
        return new ResponseEntity<>(stbService.addStbDetails(id, stb),HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Stb> getStb(@PathVariable Long id){
        return new ResponseEntity<>(stbService.getStbDetails(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Stb> updateCustomerStb(@PathVariable Long id,@RequestBody Stb stb){
        return new ResponseEntity<>(stbService.updateStbDetails(id, stb),HttpStatus.CREATED);
    }
    
}
