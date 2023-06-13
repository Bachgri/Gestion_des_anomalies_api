package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Solution;
import com.rest.api.reposiroty.SolutionRepository;
import com.rest.api.service.SolutionService;

@Service
public class SolutionServiceImpl implements SolutionService {
	
	@Autowired
	SolutionRepository solrep;
	@Override
	public List<Solution> getAll() { 
		return solrep.findAll();
	}

	@Override
	public Solution post(Solution p) { 
		return solrep.save(p);
	}

	@Override
	public Solution put(Solution p) { 
		return null;
	}

	@Override
	public Solution get(Long id) { 
		return solrep.findById(id).get();
	}

	@Override
	public Solution delete(Solution p) {
		solrep.delete(p);
		return p;
	}

}
