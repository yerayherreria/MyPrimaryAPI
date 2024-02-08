package com.jacaranda.miprimeraapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miprimeraapi.exception.ElementNotFoundExceptionv;
import com.jacaranda.miprimeraapi.model.State;
import com.jacaranda.miprimeraapi.model.Village;
import com.jacaranda.miprimeraapi.model.VillageDTO;
import com.jacaranda.miprimeraapi.repository.StateRepository;
import com.jacaranda.miprimeraapi.repository.VillageRepository;

@Service
public class VillageService {
	@Autowired
	private VillageRepository vr;
	@Autowired
	private StateRepository sr;
	
	public VillageDTO get(String id) {
		Village v =  vr.findById(id).orElse(null);
		if(v==null) {
			throw new ElementNotFoundExceptionv(id);
		}
		return new VillageDTO(v.getCodPue(),v.getName(),v.getProvince().getCodPro(),v.getProvince().getName());
	}
	
	public VillageDTO post(VillageDTO village) {
		Village v = new Village();
		State s = new State();
		if(v!=null ) {
			s = sr.findById(village.getCodPro()).orElse(s);
			v.setCodPue(village.getCodPue());
			v.setName(village.getName());
			v.setProvince(s);
			vr.save(v);
		}
		
		return village;
	}
	
	public VillageDTO put(VillageDTO village) {
		Village v = new Village();
		State s = new State();
		if(village!=null ) {
			v = vr.findById(village.getCodPue()).orElse(v);
			s = sr.findById(village.getCodPro()).orElse(s);
			v.setCodPue(village.getCodPue());
			v.setName(village.getName());
			v.setProvince(s);
			vr.save(v);
		}
		
		return village;
	}
	
	public Village delete(Village village) {
		vr.delete(village);
		return village;
	}
	
	public List<VillageDTO> getAll(){
		
		List<VillageDTO> result = new ArrayList<VillageDTO>();
		
		for(Village g : vr.findAll()) {
			VillageDTO vdto = new VillageDTO(g.getCodPue(), g.getName(), g.getProvince().getCodPro(), g.getProvince().getName());
			result.add(vdto);
		}
		
		return result;
	}
}
