package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Probleme;

public interface ProblemeRepository extends JpaRepository<Probleme, Long> {

}
