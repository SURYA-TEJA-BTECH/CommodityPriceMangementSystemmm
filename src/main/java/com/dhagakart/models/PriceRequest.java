package com.dhagakart.models;

import jakarta.validation.constraints.NotBlank;
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
public class PriceRequest {

	@NotBlank(message = "variant should be present")
	private String variant;
	
	
	
	//may be in future add date  he will get that particular date prices; 
}
