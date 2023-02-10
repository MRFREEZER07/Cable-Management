package com.cablemanagement.cable_management.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cablemanagement.cable_management.entity.History;
import com.cablemanagement.cable_management.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    HistoryService historyService;


    @GetMapping("/{id}")
    public ResponseEntity<List<History>> getHistory(@PathVariable Long id){
        return new ResponseEntity<>(historyService.getHistory(id),HttpStatus.OK);
    }


}
