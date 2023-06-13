package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Solution;

public interface SolutionService {
	public List<Solution> getAll();
	public Solution post(Solution p);
	public Solution put(Solution p);
	public Solution get(Long id);
	public Solution delete(Solution p);
}
