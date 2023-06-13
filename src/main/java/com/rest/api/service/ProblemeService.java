package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Probleme;

public interface ProblemeService {
	public List<Probleme> getAll();
	public Probleme post(Probleme p);
	public Probleme put(Probleme p);
	public Probleme get(Long id);
	public Probleme delete(long p);
}
