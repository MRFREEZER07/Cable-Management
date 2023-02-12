package com.cablemanagement.cable_management.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cablemanagement.cable_management.entity.Stb;

public interface StbRepository extends CrudRepository<Stb,Long> {
    Optional<Stb> findByCustomerId(Long id);
}
