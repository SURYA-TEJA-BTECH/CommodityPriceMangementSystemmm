package com.dhagakart.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

   	@NonNull
	private String variant;

	@NonNull
	private Integer todayPrice;

	@NonNull
	private Integer maximumPrice;

	@NonNull
	private Integer minimumPrice;

	@NonNull
	private Integer avgPrice;
	
	@NonNull
	private LocalDate priceDate;

}