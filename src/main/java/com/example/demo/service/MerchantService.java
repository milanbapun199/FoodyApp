package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Chicken;
import com.example.demo.entity.Egg;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.vo.MerchantLoginInfo;

public interface MerchantService {
	public MerchantLoginInfo logInUser(UserLogin userLogin);
	public User upsdateMerchantUser(User user);
	public Chicken saveChickenProduct(Chicken chicken);
	public Optional<User> getMerchantInfo(Long merchantId);
	public Chicken updateChicken(Chicken chicken);
	public Optional<Chicken> getChickenInfo(long parseLong);
	public boolean isChickenItemExist(long parseLong);
	public Egg saveEggProduct(Egg egg);
	public Egg updateEgg(Egg egg);
	public Optional<Egg> getEggInfo(long parseLong);
	public boolean isEggItemExist(long parseLong);
	public String generateComplaint(String complaint, List<MultipartFile> file);
	public User merchantKYC(MultipartFile profilePic, MultipartFile adharcard, String merchantId);
}
