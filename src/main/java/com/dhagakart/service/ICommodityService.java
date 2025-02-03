package com.dhagakart.service;


import com.dhagakart.models.CommodityPriceAddRequest;
import com.dhagakart.models.CommodityPriceAddResponse;
import com.dhagakart.models.PriceResponse;

public interface ICommodityService {

	public CommodityPriceAddResponse addCommodityPrice(CommodityPriceAddRequest commodity);

	public PriceResponse getCommodityPrice(String variant);

}
