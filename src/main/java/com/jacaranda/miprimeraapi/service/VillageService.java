package com.jacaranda.miprimeraapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miprimeraapi.model.Village;
import com.jacaranda.miprimeraapi.model.VillageDTO;
import com.jacaranda.miprimeraapi.repository.VillageRepository;

@Service
public class VillageService {
	@Autowired
	private VillageRepository vr;
	
	public Village get(String id) {
		return vr.findById(id).orElse(null);
	}
	
	public Village post(Village village) {
		return vr.save(village);
	}
	
	public Village put(Village village) {
		return vr.save(village);
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
