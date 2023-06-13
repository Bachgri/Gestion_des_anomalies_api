package com.rest.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.api.entity.ClientRole;
import com.rest.api.reposiroty.RoleRepo;

@Service
public interface RoleService {
	List<ClientRole> findAll();
}
