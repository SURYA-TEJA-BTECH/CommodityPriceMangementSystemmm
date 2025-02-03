package com.dhagakart.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommodityPriceAddRequest {

	@NotBlank(message = "variant should be present")
	private String variant;

	@Min(value = 1, message = "todayPrice should be at least 1 Rs")
	@NotNull(message = "Today Price  is required")
	private Integer todayPrice;

	@Min(value = 1, message = "maximumPrice should be at least 1 Rs")
	@NotNull(message = "Maximum Price  is required")
	private Integer maximumPrice;

	@Min(value = 1, message = "minimumPrice should be at least 1 Rs")
	@NotNull(message = "minimum Price  is required")
	private Integer minimumPrice;

	@Min(value = 1, message = "avgPrice should be at least 1 Rs")
	@NotNull(message = "avg Price Price  is required")
	private Integer avgPrice;

}
