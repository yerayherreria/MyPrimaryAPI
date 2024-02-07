package com.jacaranda.miprimeraapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miprimeraapi.model.State;
import com.jacaranda.miprimeraapi.model.StateDTO;
import com.jacaranda.miprimeraapi.service.StateService;

@RestController
public class StateController {

	@Autowired
	private StateService ss;
	
	@GetMapping("/state")
	public List<StateDTO> getAll() {
		return this.ss.getAll();
	}
}
