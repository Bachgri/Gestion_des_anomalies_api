package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.api.entity.Client;
import com.rest.api.entity.ClientRole;
import com.rest.api.reposiroty.ClientRepo;
import com.rest.api.reposiroty.RoleRepo;
import com.rest.api.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	ClientRepo clientRepo;
	RoleRepo roleRepo;
	PasswordEncoder passwordEncoder;
	
	public AccountServiceImpl(ClientRepo clientRepo, RoleRepo roleRepo, PasswordEncoder pe) {
		super();
		this.clientRepo = clientRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder=pe;
	}
	
	@Override
	public Client addClient(Client c) { 
		c.setPassword(passwordEncoder.encode(c.getPassword()));
		return clientRepo.saveAndFlush(c);
	}
	
	@Override
	public ClientRole addRole(ClientRole role) { 
		return roleRepo.saveAndFlush(role);
	}

	@Override
	public void addRolToUser(String username, String roleName) {
		Client client = clientRepo.findByName(username);
		ClientRole role = roleRepo.findByRoleName(roleName);
		client.getAppRoles().add(role);
		
	}

	@Override
	public Client loadUserByUserName(String userName) { 
		return clientRepo.findByName(userName);
	}

	@Override
	public List<Client> listClients() { 
		return clientRepo.findAll();
	} 
	@Override
	public Client getOne(Long id) {
		return clientRepo.findById(id).get();
	}
}
