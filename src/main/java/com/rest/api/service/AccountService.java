package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Client;
import com.rest.api.entity.ClientRole;

public interface AccountService {
	public Client addClient(Client c);
	public ClientRole addRole(ClientRole role);
	public void addRolToUser(String username, String roleName);
	public Client loadUserByUserName(String userName);
	public List<Client> listClients();
	public Client getOne(Long id);
	
}