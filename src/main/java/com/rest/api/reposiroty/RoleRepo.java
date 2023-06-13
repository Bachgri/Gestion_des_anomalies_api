package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Client;
import com.rest.api.entity.ClientRole;

public interface RoleRepo extends JpaRepository<ClientRole, Long> {
	public ClientRole findByRoleName(String rn);
	
}
