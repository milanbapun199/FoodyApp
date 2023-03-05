package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Chicken;
import com.example.demo.entity.Egg;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.repo.UserRepositary;
import com.example.demo.service.MerchantService;
import com.example.demo.vo.MerchantLoginInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegistration {
	
//	@Autowired
//	  TutorialRepository tutorialRepository;
	@Autowired
	UserRepositary userRepositary;
	
	@Autowired
	MerchantService merchantService;
	
	@GetMapping("/getUser")  
	public List<User> getTutorialsDetails()   
	{  
		return userRepositary.findAll();
	} 
	@PostMapping("/user" )
	  public ResponseEntity<User> createTutorial(@RequestBody User user) {
	    try {
	      User _user = userRepositary
	          .save(user);
	      return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@PostMapping("/merchant-login" )
	  public MerchantLoginInfo logInUser(@RequestBody UserLogin userLogin) {
		return merchantService.logInUser(userLogin);
		
	  }
	@GetMapping("/getMerchantInfo" )
	  public Optional<User> getMerchantInfo(@RequestParam ("merchantId") String merchantId) {
		Optional<User> merchantInfo = merchantService.getMerchantInfo(Long.parseLong(merchantId));
		System.out.println(merchantInfo);
		return merchantInfo;
		
	  }
	@GetMapping(value = "/getMerchantCurrentRates" )
	  public String getMerchantCurrentRates(@RequestParam ("merchantId") String merchantId) {
		Chicken chickenInfo = merchantService.getChickenInfo(Long.parseLong(merchantId)).orElse(null);
		Egg eggInfo = merchantService.getEggInfo(Long.parseLong(merchantId)).orElse(null);
		return getProductInfo(chickenInfo, eggInfo);
		
	  }
	private String getProductInfo(Chicken chickenInfo, Egg eggInfo) {
		ObjectMapper m = new ObjectMapper();
		Map<String , Object> finalMap=new HashMap<>();
		Map<String, Object> map = m.convertValue(chickenInfo, Map.class);
		System.out.println(map);
		for (Entry<String, Object> pair : map.entrySet()) {
			System.out.println(pair.getKey()+ !(pair.getKey().equals("chickenId")));
			
			if(!(pair.getKey().equals("chickenId")) && !(pair.getKey().equals("merchantId"))) {
				if(!(pair.getValue().equals(0.0))) {
					finalMap.put(pair.getKey(), pair.getValue());
				}
			}
		}
		Map<String, Object>  map2= m.convertValue(eggInfo, Map.class);
		for (Entry<String, Object> pair : map2.entrySet()) {
			if(!(pair.getKey().equals("eggId")) && !(pair.getKey().equals("merchantId"))) {
				if(!(pair.getValue().equals(0.0))) {
					finalMap.put(pair.getKey(), pair.getValue());
				}
			}
		}
		ObjectMapper mapper= new ObjectMapper();
		String result=null;
		try {
			 result = mapper.writeValueAsString(finalMap);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@PutMapping("/update-user")
	public User updateMerchantUser(@RequestBody User user){
		return merchantService.upsdateMerchantUser(user);
	}
	@PutMapping(value = "/merchant-kyc" , consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public User merchantKYC(@RequestPart("profilePic") MultipartFile profilePic, @RequestPart("adharcard") MultipartFile adharcard,@RequestPart("merchantId") String merchantId){
		return merchantService.merchantKYC(profilePic, adharcard, merchantId);
	}
	
	@PostMapping("/addChicken" )
	  public ResponseEntity<Chicken> saveChickenProduct(@RequestBody Chicken chicken) {
	    try {
	      Chicken _chicken= merchantService.saveChickenProduct(chicken);
	      return new ResponseEntity<>(_chicken, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@PutMapping("/update-chciken")
	public Chicken updateChickenItem(@RequestBody Chicken chicken){
		System.out.println("Existing chicken rates: "+chicken);
		return merchantService.updateChicken(chicken);
	}
	@GetMapping("/getChickenItem" )
	  public Optional<Chicken> getChickenInfo(@RequestParam ("merchantId") String merchantId) {
		Optional<Chicken> chickenInfo = merchantService.getChickenInfo(Long.parseLong(merchantId));
		System.out.println(chickenInfo);
		return chickenInfo;
		
	  }
	@GetMapping("/isChickenItemExist" )
	  public boolean isChickenItemExist(@RequestParam ("merchantId") String merchantId) {
		boolean isChickenItemExist = merchantService.isChickenItemExist(Long.parseLong(merchantId));
		System.out.println(isChickenItemExist);
		return isChickenItemExist;
		
	  }
	
	@PostMapping("/addEgg" )
	  public ResponseEntity<Egg> saveEggProduct(@RequestBody Egg egg) {
	    try {
	      Egg _egg= merchantService.saveEggProduct(egg);
	      return new ResponseEntity<>(_egg, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@PutMapping("/update-egg")
	public Egg updateEggItem(@RequestBody Egg egg){
		System.out.println("Existing egg rates: "+egg);
		return merchantService.updateEgg(egg);
	}
	@GetMapping("/getEggItem" )
	  public Optional<Egg> getEggInfo(@RequestParam ("merchantId") String merchantId) {
		Optional<Egg> eggInfo = merchantService.getEggInfo(Long.parseLong(merchantId));
		System.out.println(eggInfo);
		return eggInfo;
		
	  }
	@GetMapping("/isEggItemExist" )
	  public boolean isEggItemExist(@RequestParam ("merchantId") String merchantId) {
		boolean isEggItemExist = merchantService.isEggItemExist(Long.parseLong(merchantId));
		System.out.println(isEggItemExist);
		return isEggItemExist;
		
	  }
	@PostMapping(value = "/generateComplaint" , consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	  public String generateComplaint(@RequestPart("complaint") String complaint, @RequestPart("file") List<MultipartFile> file) throws IOException {
		return merchantService.generateComplaint(complaint, file);
		
	}
//	    try {
//	      Egg _egg= merchantService.saveEggProduct(egg);
//	      return new ResponseEntity<>(_egg, HttpStatus.CREATED);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }
}
