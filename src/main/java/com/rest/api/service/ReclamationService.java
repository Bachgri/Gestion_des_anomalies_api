package com.rest.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.api.entity.Reclamation;

public interface ReclamationService {
	public List<Reclamation> getAll();
	public Reclamation post(Reclamation p);
	public Reclamation put(Reclamation p);
	public Reclamation get(Long id);
	public Reclamation delete(Long p);
	public void setRecImg(long userid, String imageUrl);
}
