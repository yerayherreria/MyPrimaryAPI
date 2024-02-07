package com.jacaranda.miprimeraapi.model;

import java.util.List;

import jakarta.persistence.Column;

public class StateDTO {
	private String codPro;
	private String name;
	private List<VillageDTO> villages;
	
	public StateDTO() {
		super();
	}

	public StateDTO(String codPro, String name, List<VillageDTO> villages) {
		super();
		this.codPro = codPro;
		this.name = name;
		this.villages = villages;
	}

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VillageDTO> getVillages() {
		return villages;
	}

	public void setVillages(List<VillageDTO> villages) {
		this.villages = villages;
	}
	
//	public static List<StateDTO> convert(){
//		
//	}
	
	
}
