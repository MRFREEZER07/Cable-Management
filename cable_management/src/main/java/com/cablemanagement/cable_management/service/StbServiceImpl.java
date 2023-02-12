package com.cablemanagement.cable_management.service;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cablemanagement.cable_management.entity.Stb;
import com.cablemanagement.cable_management.exception.CustomerNotFoundException;
import com.cablemanagement.cable_management.exception.StbNotFoundException;
import com.cablemanagement.cable_management.entity.Customer;
import com.cablemanagement.cable_management.repository.CustomerRepository;
import com.cablemanagement.cable_management.repository.StbRepository;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor

@Service
public class StbServiceImpl implements StbService {


CustomerRepository customerRepository;
StbRepository stbRepository;


    @Override
    public Stb addStbDetails(long id, Stb stb) {
        
        Optional<Customer> customer = customerRepository.findById(id);
        Customer unwrappedCustomer = unwrapCustomer(customer,id);
        stb.setCustomer(unwrappedCustomer);
        return stbRepository.save(stb);
       
    }

    @Override
    public Stb getStbDetails(long id) {
        Optional<Stb> stbDetails = stbRepository.findByCustomerId(id);
        Stb unwrappedStb  = unwrapStb(stbDetails,id);
        return unwrappedStb;
    }
    
  

    @Override
    public Stb updateStbDetails(long id, Stb stb) {
        Optional<Stb> stb1 = stbRepository.findByCustomerId(id);
        Stb unwrappedStb = unwrapStb(stb1,id);
        if(stb.getStboxNumber()!= null){
            unwrappedStb.setStboxNumber(stb.getStboxNumber());
        }
        if(stb.getStboxId()!= null){
            unwrappedStb.setStboxId(stb.getStboxId());
        }
        if(stb.getStboxCustNumber()!= null){
            unwrappedStb.setStboxCustNumber(stb.getStboxCustNumber());
        }
        if(stb.getStboxType()!=null){
            unwrappedStb.setStboxType(stb.getStboxType());
        }
        return stbRepository.save(unwrappedStb);

       
    }

    public static Customer unwrapCustomer(Optional<Customer> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

    public static Stb unwrapStb(Optional<Stb> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new StbNotFoundException(id);
        }
    }



    

}
