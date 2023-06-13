package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

}
