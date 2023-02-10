package com.cablemanagement.cable_management.repository;
import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.cablemanagement.cable_management.entity.History;

public interface HistoryRepository extends CrudRepository <History,Long>{
    List<History> findAllById(Long id);
}
