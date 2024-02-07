package com.jacaranda.miprimeraapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miprimeraapi.model.State;
import com.jacaranda.miprimeraapi.model.StateDTO;
import com.jacaranda.miprimeraapi.model.Village;
import com.jacaranda.miprimeraapi.model.VillageDTO;
import com.jacaranda.miprimeraapi.repository.StateRepository;
import com.jacaranda.miprimeraapi.repository.VillageRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository sr;
	@Autowired
	private VillageRepository vr;
	
	public State get(String id) {
		return sr.findById(id).orElse(null);
	}
	
	public State save(State state) {
		return sr.save(state);
	}
	
	public List<StateDTO> getAll(){
		
		List<StateDTO> result = new ArrayList<StateDTO>();	
		
		for(State s : sr.findAll()) {
			List<VillageDTO> village = new ArrayList<VillageDTO>();
			
			for(Village g : vr.findAll()) {
				VillageDTO vdto = new VillageDTO(g.getCodPue(), g.getName(), g.getProvince().getCodPro(), g.getProvince().getName());
				village.add(vdto);
			}
			StateDTO vdto = new StateDTO(s.getCodPro(),s.getName(),village);
			result.add(vdto);
		}
		
		return result;
	}
}
