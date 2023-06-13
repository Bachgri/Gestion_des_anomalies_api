package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Reclamation;
import com.rest.api.reposiroty.ReclamationRepository;
import com.rest.api.service.ReclamationService;

@Service
public class ReclamationServiceImpl implements ReclamationService {

	@Autowired 
	ReclamationRepository recrep;
	
	@Override
	public List<Reclamation> getAll() {
		return recrep.findAll();
	}

	@Override
	public Reclamation post(Reclamation p) { 
		return recrep.save(p);
	}

	@Override
	public Reclamation put(Reclamation p) { 
		return null;
	}

	@Override
	public Reclamation get(Long id) { 
		return recrep.findById(id).get();
	}

	@Override
	public Reclamation delete(Long p) {
		Reclamation pp =recrep.findById(p).get();
		recrep.delete(pp);
		return pp;
	}
	@Override
	public void setRecImg(long userid, String imageUrl) {
		Reclamation rec = recrep.findById(userid).get();
		rec.setImgurl(imageUrl);
		
	}

}
