package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RateDisabled;
import com.example.demo.repo.RateDisabledRepositary;

@Service
public class RateDisabledServiceImpl implements RateDisabledService{
	
	@Autowired
	RateDisabledRepositary rateDisabledRepositary;
	
	@Override
	public boolean disableRate(String merchantId, String productName) {
		RateDisabled rateDisabled=new RateDisabled();
		rateDisabled.setMerchantId(Long.parseLong(merchantId));
		rateDisabled.setProductName(productName);
		rateDisabled.setRateStatus("disabled");
		rateDisabledRepositary.save(rateDisabled);
		return false;
	}

	@Override
	@Transactional
	public boolean enableRate(String merchantId, String productName) {
//		 rateDisabledRepositary.deleteBymerchantIdandproductName(Long.parseLong(merchantId), productName);
		 return true;
	}

}
