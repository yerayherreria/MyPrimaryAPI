package com.jacaranda.miprimeraapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miprimeraapi.model.Village;
import com.jacaranda.miprimeraapi.model.VillageDTO;
import com.jacaranda.miprimeraapi.service.VillageService;

@RestController
public class VillageController {
	@Autowired
	private VillageService vs;
	
	@GetMapping("/village")
	public List<VillageDTO> getAll() {
		return this.vs.getAll();
	}
	
	@GetMapping("/village/{id}")
	public Village get(@PathVariable String id) {
		return this.vs.get(id);
	}
	
	@PostMapping("/village")
	public Village add(@RequestBody Village elemento) {
		return this.vs.post(elemento);
	}
	
	@PutMapping("/village/{id}")
	public Village edit(@RequestBody Village elemento, @PathVariable String id) {
		if (this.vs.get(id)!= null) {
			return this.vs.put(elemento);
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/village/{id}")
	public Village del(@PathVariable String id) {
		if (this.vs.get(id)!= null) {
			Village elemento = this.vs.get(id);
			
			return this.vs.delete(elemento);
		}else {
			return null;
		}
	}
}
