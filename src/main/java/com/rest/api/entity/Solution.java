package com.rest.api.entity;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data		
@Table(name = "solutions")
public class Solution { 
	@Id													
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String titre;
														
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "probleme_id") 
	private Probleme probleme;*/ 
}
