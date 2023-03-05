package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ChickenResponse;
import com.example.demo.entity.EggResponse;
import com.example.demo.service.HomeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@GetMapping("/filterByEgg" )
	  public List<EggResponse> filterByEgg() {
		List<EggResponse> filterByEgg = homeService.filterByEgg();
		return filterByEgg;
		
	  }
	@GetMapping("/filterByChicken" )
	  public List<ChickenResponse> filterByChicken() {
		List<ChickenResponse> filterByChicken = homeService.filterByChicken();
		return filterByChicken;
		
	  }
	@GetMapping("/loadingAllData" )
	  public String loadingAllData() {
		List<EggResponse> filterByEgg = homeService.filterByEgg();
		List<ChickenResponse> filterByChicken = homeService.filterByChicken();
		return filterByEgg.toString()+filterByChicken.toString();
	  }
}
