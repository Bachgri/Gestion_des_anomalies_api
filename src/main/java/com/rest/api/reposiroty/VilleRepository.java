package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

}
