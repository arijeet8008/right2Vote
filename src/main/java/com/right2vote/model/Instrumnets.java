package com.right2vote.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrumnets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer instrumnetId;
	
	@NotNull
	private Double weight;
	
	@NotNull
	private Double volume;
	
	@NotNull
	private Double  scientificValue;
	
}
