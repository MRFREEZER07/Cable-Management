package com.cablemanagement.cable_management.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.cablemanagement.cable_management.entity.History;
import com.cablemanagement.cable_management.exception.HistoryNotFoundException;
import com.cablemanagement.cable_management.repository.HistoryRepository;
@Service
public class HistoryServiceImpl implements HistoryService{

    HistoryRepository historyRepository;

    @Override
    public List<History> getHistory(Long id) {
    //    List<History> historyList =historyRepository.findAllById(id);

        //  List<History>unWrapedHistory = unwrapHistory(historyList,id);
         return null;
      
        }

        @Override
        public  List<History> unwrapHistory(Optional<List<History>> entity, Long id) {
            if (entity.isPresent()) {
                return entity.get();
            } else {
                throw new HistoryNotFoundException(id);
            }
        }

        

   

}
