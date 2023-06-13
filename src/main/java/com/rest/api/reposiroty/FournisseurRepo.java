package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Fournisseur;

public interface FournisseurRepo extends JpaRepository<Fournisseur, Long> {

}
