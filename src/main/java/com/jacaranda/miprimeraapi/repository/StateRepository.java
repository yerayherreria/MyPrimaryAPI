package com.jacaranda.miprimeraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miprimeraapi.model.State;

public interface StateRepository extends JpaRepository<State, String> {

}
