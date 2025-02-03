package com.dhagakart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhagakart.models.CommodityPriceAddRequest;
import com.dhagakart.models.CommodityPriceAddResponse;
import com.dhagakart.models.PriceRequest;
import com.dhagakart.models.PriceResponse;
import com.dhagakart.service.ICommodityService;
import com.dhagakart.validator.TokenValidator;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/api/today")
@RestController
@AllArgsConstructor
public class commodityPriceController {

	private final ICommodityService commodityService;
	private final TokenValidator tokenValidator;

	@PostMapping("/price")
	public ResponseEntity<?> fetchCommodityPrice(@Valid @RequestBody PriceRequest priceRequest,
			@RequestHeader("Authorization") String token) {

		tokenValidator.validateToken(token);

		PriceResponse priceResponse = commodityService.getCommodityPrice(priceRequest.getVariant());
		return new ResponseEntity<>(priceResponse, HttpStatus.OK);

	}

	@PostMapping("/addPrice")
	public ResponseEntity<CommodityPriceAddResponse> addCommodityPrice(
			@Valid @RequestBody CommodityPriceAddRequest priceAddRequest,
			@RequestHeader("Authorization") String token) {

		tokenValidator.validateToken(token);
		CommodityPriceAddResponse priceAddResponse = commodityService.addCommodityPrice(priceAddRequest);

		return new ResponseEntity<>(priceAddResponse, HttpStatus.CREATED);

	}

}
