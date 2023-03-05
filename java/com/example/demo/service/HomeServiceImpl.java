package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Chicken;
import com.example.demo.entity.ChickenResponse;
import com.example.demo.entity.Egg;
import com.example.demo.entity.EggResponse;
import com.example.demo.repo.ChickenRepositary;
import com.example.demo.repo.EggRepositary;


@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	ChickenRepositary chickenRepositary;
	
	@Autowired
	EggRepositary eggRepositary;

	@Override
	public List<EggResponse> filterByEgg() {
			List<Egg> AllEggItem = eggRepositary.findAll();
			EggResponse eggResponse=null;
			List<EggResponse> responseEgg=new ArrayList<>();
			System.out.println(AllEggItem);
			for(Egg eggItem: AllEggItem) {
				//used reflection API
				Field[] fields = eggItem.getClass().getDeclaredFields();
				for(Field field: fields) {
				    if(!field.getName().equals("eggId") && !field.getName().equals("merchantId")) {
				    	if(field.getName().equals("largeEgg") && !eggItem.getLargeEgg().equals(0.0)) {
				    		eggResponse=new EggResponse();
				    		eggResponse.setProductType("egg");
				    		eggResponse.setEggName(field.getName());
				    		eggResponse.setPrice(eggItem.getLargeEgg());
				    		eggResponse.setMerchantId(eggItem.getMerchantId());
				    		responseEgg.add(eggResponse);
				    	}else if(field.getName().equals("mediumEgg") && !eggItem.getMediumEgg().equals(0.0)) {
				    		eggResponse=new EggResponse();
				    		eggResponse.setProductType("egg");
				    		eggResponse.setEggName(field.getName());
				    		eggResponse.setPrice(eggItem.getMediumEgg());
				    		eggResponse.setMerchantId(eggItem.getMerchantId());
				    		responseEgg.add(eggResponse);
				    	}else if(field.getName().equals("smallEgg") && !eggItem.getSmallEgg().equals(0.0)) {
				    		eggResponse=new EggResponse();
				    		eggResponse.setProductType("egg");
				    		eggResponse.setEggName(field.getName());
				    		eggResponse.setPrice(eggItem.getSmallEgg());
				    		eggResponse.setMerchantId(eggItem.getMerchantId());
				    		responseEgg.add(eggResponse);
				    	}else if(field.getName().equals("desiEgg") && !eggItem.getDesiEgg().equals(0.0)) {
				    		eggResponse=new EggResponse();
				    		eggResponse.setProductType("egg");
				    		eggResponse.setEggName(field.getName());
				    		eggResponse.setPrice(eggItem.getDesiEgg());
				    		eggResponse.setMerchantId(eggItem.getMerchantId());
				    		responseEgg.add(eggResponse);
				    	}else if(field.getName().equals("doublekesharEgg") && !eggItem.getDoublekesharEgg().equals(0.0)) {
				    		eggResponse=new EggResponse();
				    		eggResponse.setProductType("egg");
				    		eggResponse.setEggName(field.getName());
				    		eggResponse.setPrice(eggItem.getDoublekesharEgg());
				    		eggResponse.setMerchantId(eggItem.getMerchantId());
				    		responseEgg.add(eggResponse);
				    	}
				    		
				    }
				}
			}
			
		return responseEgg;
		
	}

	@Override
	public void loadingAllData() {
		filterByEgg();
		
	}

	@Override
	public List<ChickenResponse> filterByChicken() {
		List<Chicken> allChickenItem = chickenRepositary.findAll();
		ChickenResponse chickenResponse=null;
		List<ChickenResponse> responseChicken=new ArrayList<>();
		System.out.println(allChickenItem);
		for(Chicken chickenItem: allChickenItem) {
			//used reflection API
			Field[] fields = chickenItem.getClass().getDeclaredFields();
			for(Field field: fields) {
			    if(!field.getName().equals("chickenId") && !field.getName().equals("merchantId")) {
			    	if(field.getName().equals("desi") && !chickenItem.getDesi().equals(0.0) && (chickenItem.getDesi() != null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getDesi());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}else if(field.getName().equals("liyor") && !chickenItem.getLiyor().equals(0.0)&& (chickenItem.getLiyor() != null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getLiyor());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}else if(field.getName().equals("banraj") && !chickenItem.getBanraj().equals(0.0)&& (chickenItem.getBanraj() != null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getBanraj());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}else if(field.getName().equals("broilerBoneless") && !chickenItem.getBroilerBoneless().equals(0.0)&& !(chickenItem.getBroilerBoneless() == null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getBroilerBoneless());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}else if(field.getName().equals("broilerSkinless") && !chickenItem.getBroilerSkinless().equals(0.0)&& !(chickenItem.getBroilerSkinless() == null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getBroilerSkinless());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}
			    	else if(field.getName().equals("broilerLegPiece") && !chickenItem.getBroilerLegPiece().equals(0.0)&& !(chickenItem.getBroilerLegPiece() == null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getBroilerLegPiece());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}
			    	else if(field.getName().equals("hechery") && !chickenItem.getHechery().equals(0.0)&& !(chickenItem.getHechery() == null)) {
			    		chickenResponse=new ChickenResponse();
			    		chickenResponse.setProductType("chicken");
			    		chickenResponse.setChickeName(field.getName());
			    		chickenResponse.setPrice(chickenItem.getHechery());
			    		chickenResponse.setMerchantId(chickenItem.getMerchantId());
			    		responseChicken.add(chickenResponse);
			    	}
			    		
			    }
			}
		}
		return responseChicken;
	}
}
