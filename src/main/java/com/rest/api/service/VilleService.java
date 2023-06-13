package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Ville;

public interface VilleService {
	public List<Ville> getAll();
	public Ville post(Ville p);
	public Ville put(Ville p);
	public Ville get(Long id);
	public Ville delete(Ville p);
}
