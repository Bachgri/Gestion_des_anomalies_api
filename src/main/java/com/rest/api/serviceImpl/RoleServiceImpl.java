package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.api.entity.ClientRole;
import com.rest.api.reposiroty.RoleRepo;
import com.rest.api.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	RoleRepo rolerepo;

	public RoleServiceImpl(RoleRepo rolerepo) { 
		this.rolerepo = rolerepo;
	}
	@Override
	public List<ClientRole> findAll(){
		return rolerepo.findAll();
	}
	
}
