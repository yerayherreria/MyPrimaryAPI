package com.jacaranda.miprimeraapi.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="provincias")
public class State {
	@Id
	@Column(name="codpro")
	private String codPro;
	
	@Column(name="nombre")
	private String name;
	
	@OneToMany(mappedBy = "province")
	private List<Village> listVillages;

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
	
	public List<Village> getListVillages() {
		return listVillages;
	}

	public void setListVillages(List<Village> listVillages) {
		this.listVillages = listVillages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codPro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(codPro, other.codPro);
	}
	
}
