package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
