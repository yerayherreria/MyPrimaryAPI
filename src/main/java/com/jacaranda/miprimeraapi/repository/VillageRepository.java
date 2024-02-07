package com.jacaranda.miprimeraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miprimeraapi.model.Village;

public interface VillageRepository extends JpaRepository<Village, String> {

}
