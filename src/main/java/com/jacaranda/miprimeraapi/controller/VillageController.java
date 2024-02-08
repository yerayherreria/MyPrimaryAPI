package com.jacaranda.miprimeraapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miprimeraapi.exception.ApiError;
import com.jacaranda.miprimeraapi.exception.ElementNotFoundExceptionv;
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
	public ResponseEntity<Object> get(@PathVariable String id) {
		VillageDTO result = this.vs.get(id);
		return ResponseEntity.ok(result);
		
	}
	
	@ExceptionHandler(ElementNotFoundExceptionv.class)
	public ResponseEntity<ApiError>handleElementNotFoundException(ElementNotFoundExceptionv e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
			e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@PostMapping("/village")
	public VillageDTO add(@RequestBody VillageDTO elemento) {	
		return this.vs.post(elemento);
	}
	
	@PutMapping("/village/{id}")
	public VillageDTO edit(@RequestBody VillageDTO elemento, @PathVariable String id) {
		VillageDTO result = this.vs.get(id);
		if (result == null ) {
//			return ResponseEntity.notFound().build();
			throw new ElementNotFoundExceptionv(id);
		}else {
			return this.vs.put(elemento);
		}
	
	}
	
//	@DeleteMapping("/village/{id}")
//	public Village del(@PathVariable String id) {
//		if (this.vs.get(id)!= null) {
//			Village elemento = this.vs.get(id);
//			
//			return this.vs.delete(elemento);
//		}else {
//			return null;
//		}
//	}
}
