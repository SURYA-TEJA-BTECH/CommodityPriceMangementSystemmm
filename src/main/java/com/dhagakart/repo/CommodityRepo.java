package com.dhagakart.repo;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhagakart.entity.Commodity;

public interface CommodityRepo extends JpaRepository<Commodity, Long> {

	public Optional<Commodity> findByVariantAndPriceDate(String variant,LocalDate todayDate);

	public boolean existsByVariantAndPriceDate(String variant, LocalDate now);
	
	
	
	
	

}
