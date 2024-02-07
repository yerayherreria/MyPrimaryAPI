package com.jacaranda.miprimeraapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class VillageDTO {
	
	private String codPue;
	
	private String name;
	
	private String codPro;
	
	private String state;

	public VillageDTO() {
		super();
	}

	public VillageDTO(String codPue, String name, String codPro, String state) {
		super();
		this.codPue = codPue;
		this.name = name;
		this.codPro = codPro;
		this.state = state;
	}

	public String getCodPue() {
		return codPue;
	}

	public void setCodPue(String codPue) {
		this.codPue = codPue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
