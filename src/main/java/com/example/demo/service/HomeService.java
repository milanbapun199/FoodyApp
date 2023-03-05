package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ChickenResponse;
import com.example.demo.entity.EggResponse;

public interface HomeService {

	List<EggResponse> filterByEgg();

	void loadingAllData();

	List<ChickenResponse> filterByChicken();

}
