package com.jacaranda.miprimeraapi.model;

import java.util.Objects;

import com.jacaranda.miprimeraapi.model.State;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pueblos")
public class Village {
	@Id
	@Column(name="codpue")
	private String codPue;
	
	@Column(name="nombre")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="codpro")
	private State province;

	public Village() {
		super();
 	}

	public Village(String codPue, String name, State province) {
		super();
		this.codPue = codPue;
		this.name = name;
		this.province = province;
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

	public State getProvince() {
		return province;
	}

	public void setProvince(State province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codPue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Village other = (Village) obj;
		return Objects.equals(codPue, other.codPue);
	}
}
