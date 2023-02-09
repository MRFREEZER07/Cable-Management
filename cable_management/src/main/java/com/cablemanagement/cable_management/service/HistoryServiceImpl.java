package com.cablemanagement.cable_management.service;

import java.util.List;

import com.cablemanagement.cable_management.entity.History;
import com.cablemanagement.cable_management.repository.HistoryRepository;

public class HistoryServiceImpl implements HistoryService{

    HistoryRepository historyRepository;

    @Override
    public List<History> getHistory(Long id) {
        return (List<History>) historyRepository.findAllById(id);
    }

    

}
