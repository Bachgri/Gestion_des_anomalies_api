package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Ville;
import com.rest.api.reposiroty.VilleRepository;
import com.rest.api.service.VilleService;
@Service
public class VilleServiceImpl implements VilleService {

	@Autowired 
	VilleRepository villerep;
	
	@Override
	public List<Ville> getAll() { 
		return villerep.findAll();
	}

	@Override
	public Ville post(Ville p) {
		return villerep.save(p);
	}

	@Override
	public Ville put(Ville p) {
		return null;
	}

	@Override
	public Ville get(Long id) {
		return villerep.findById(id).get();
	}

	@Override
	public Ville delete(Ville p) { 
		villerep.delete(p);
		return p;
	}

}
