package com.cablemanagement.cable_management.service;

import java.util.List;
import java.util.Optional;

import com.cablemanagement.cable_management.entity.History;


public interface HistoryService {

    List<History> getHistory(Long id);
    List<History> unwrapHistory(Optional<List<History>> entity, Long id);
}
