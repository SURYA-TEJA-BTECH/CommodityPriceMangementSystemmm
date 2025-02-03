package com.dhagakart.models;

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
public class PriceResponse {


	private Integer todayPrice;

	private Integer maximumPrice;

	private Integer minimumPrice;

	private Integer avgPrice;

}
