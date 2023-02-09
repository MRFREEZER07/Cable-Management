package com.cablemanagement.cable_management.service;

import java.util.List;

import com.cablemanagement.cable_management.entity.History;


public interface HistoryService {

    List<History> getHistory(Long id);

}
