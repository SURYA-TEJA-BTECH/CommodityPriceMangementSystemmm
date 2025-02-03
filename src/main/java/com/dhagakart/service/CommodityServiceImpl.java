package com.dhagakart.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.dhagakart.entity.Commodity;
import com.dhagakart.exception.PriceNotFoundException;
import com.dhagakart.exception.DuplicatePriceException;
import com.dhagakart.models.CommodityPriceAddRequest;
import com.dhagakart.models.CommodityPriceAddResponse;
import com.dhagakart.models.PriceResponse;
import com.dhagakart.repo.CommodityRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommodityServiceImpl implements ICommodityService {

	private CommodityRepo commodityRepo;

	@Override
	public CommodityPriceAddResponse addCommodityPrice(CommodityPriceAddRequest commodity) {

		if (commodityRepo.existsByVariantAndPriceDate(commodity.getVariant(), LocalDate.now())) {
			throw new DuplicatePriceException("Price already exists for variant: " + commodity.getVariant());
		}

		Commodity commodityy = new Commodity(commodity.getVariant(), commodity.getTodayPrice(),
				commodity.getMaximumPrice(), commodity.getMinimumPrice(), commodity.getAvgPrice(), LocalDate.now());

		commodityRepo.save(commodityy);

		return new CommodityPriceAddResponse(200, "Added successfully");
	}

	@Override
	public PriceResponse getCommodityPrice(String variant) {

		Commodity commodity = commodityRepo.findByVariantAndPriceDate(variant, LocalDate.now())
				.orElseThrow(() -> new PriceNotFoundException("Given Commodity is not there"));

		return new PriceResponse(commodity.getTodayPrice(), commodity.getMaximumPrice(), commodity.getMinimumPrice(),
				commodity.getAvgPrice());
	}

}
