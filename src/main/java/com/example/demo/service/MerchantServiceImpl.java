package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Chicken;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.Egg;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.repo.ChickenRepositary;
import com.example.demo.repo.ComplaintRepositary;
import com.example.demo.repo.EggRepositary;
import com.example.demo.repo.UserRepositary;
import com.example.demo.vo.MerchantLoginInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MerchantServiceImpl implements MerchantService{

	private static String UPLOAD_FOLDER="D:\\major-project\\images\\";
	private static String UPLOAD_MERCHANT_PROFILE_PIC= "D:\\major-project\\images\\merchant-profile-pic\\";
	private static String UPLOAD_MERCHANT_ADHARCARD="D:\\major-project\\images\\merchant-adharcard\\";
	@Autowired
	UserRepositary userRepositary;
	
	@Autowired
	ChickenRepositary chickenRepositary;
	
	@Autowired
	EggRepositary eggRepositary;
	
	@Autowired
	ComplaintRepositary complaintRepositary;
	
	@Override
	public MerchantLoginInfo logInUser(UserLogin userLogin) {
		User userName = userRepositary.findByuserName(userLogin.getUserName());
		MerchantLoginInfo user=new MerchantLoginInfo();
		if(userName == null) {
//			System.out.println("userNAme is null");
			user.setUserName("userName not valid");
			return user;
		}else {
			System.out.println("username is exist");
			if(userName.getPassword().equals(userLogin.getPassword())) {
				//set all User data into LoginInfo object
				user.setfName(userName.getfName());
				user.setlName(userName.getlName());
				user.setEmail(userName.getEmail());
				user.setGender(userName.getGender());
				user.setId(userName.getId());
				user.setMobNo(userName.getMobNo());
				user.setShopName(userName.getShopName());
				
			}else {
				//password invalid
				user.setPassword("Invalid Password");
			}
			return user;
		}
	}

	@Override
	public User upsdateMerchantUser(User user) {
		User existingMerchantUser = userRepositary.findById(user.getId()).orElse(null);
		existingMerchantUser.setfName(user.getfName());
		existingMerchantUser.setlName(user.getlName());
		existingMerchantUser.setMobNo(user.getMobNo());
		existingMerchantUser.setEmail(user.getEmail());
		existingMerchantUser.setShopName(user.getShopName());
		existingMerchantUser.setArea(user.getArea());
		existingMerchantUser.setPin(user.getPin());
		return userRepositary.save(existingMerchantUser);
	}

	@Override
	public Chicken saveChickenProduct(Chicken chicken) {
		return chickenRepositary.save(chicken);
		
	}

	@Override
	public Optional<User> getMerchantInfo(Long merchantId) {
		return userRepositary.findById(merchantId);
	}

	@Override
	public Chicken updateChicken(Chicken chicken) {
		Chicken existingChickenItem = chickenRepositary.findByMerchantId(chicken.getMerchantId()).orElse(null);
		existingChickenItem.setBanraj(chicken.getBanraj());
		existingChickenItem.setBroilerBoneless(chicken.getBroilerBoneless());
		existingChickenItem.setBroilerLegPiece(chicken.getBroilerLegPiece());
		existingChickenItem.setBroilerSkinless(chicken.getBroilerSkinless());
		existingChickenItem.setDesi(chicken.getDesi());
		existingChickenItem.setHechery(chicken.getHechery());
		existingChickenItem.setLiyor(chicken.getLiyor());
		return chickenRepositary.save(existingChickenItem);
	}

	@Override
	public Optional<Chicken> getChickenInfo(long merchantId) {
		Optional<Chicken> chickenItem=chickenRepositary.findByMerchantId(merchantId);
		return chickenItem;
	}

	@Override
	public boolean isChickenItemExist(long merchantId) {
		return chickenRepositary.existsByMerchantId(merchantId);
	}

	@Override
	public Egg saveEggProduct(Egg egg) {
		return eggRepositary.save(egg);
	}

	@Override
	public Egg updateEgg(Egg egg) {
		Egg existingEggItem = eggRepositary.findByMerchantId(egg.getMerchantId()).orElse(null);
		existingEggItem.setDesiEgg(egg.getDesiEgg());
		existingEggItem.setDoublekesharEgg(egg.getDoublekesharEgg());
		existingEggItem.setLargeEgg(egg.getLargeEgg());
		existingEggItem.setMediumEgg(egg.getMediumEgg());
		existingEggItem.setSmallEgg(egg.getSmallEgg());
		return eggRepositary.save(existingEggItem);
	}

	@Override
	public Optional<Egg> getEggInfo(long merchantId) {
		Optional<Egg> eggItem=eggRepositary.findByMerchantId(merchantId);
		return eggItem;
	}

	@Override
	public boolean isEggItemExist(long merchantId) {
		return eggRepositary.existsByMerchantId(merchantId);
	}

	@Override
	public String generateComplaint(String complaint, List<MultipartFile> file) {
		Complaint c=new Complaint();
		String fullPath="";
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		try {
			c = objectMapper.readValue(complaint, Complaint.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(MultipartFile f: file) {
			if(!f.isEmpty()) {
				byte[] byteArry = null;
				try {
					byteArry = f.getBytes();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Path path=Paths.get(UPLOAD_FOLDER+f.getOriginalFilename());
				System.out.println(path);
				fullPath=fullPath+path+",";
				c.setFilePath(fullPath);
				try {
					Files.write(path, byteArry);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		c.setStatus("open");
		complaintRepositary.save(c);
		System.out.println(c);
		return c.toString();
	}

	@Override
	public User merchantKYC(MultipartFile profilePic, MultipartFile adharcard, String merchantId) {
		if(!profilePic.isEmpty()) {
			try {
				byte[] byteArray= profilePic.getBytes();
				Path path=Paths.get(UPLOAD_MERCHANT_PROFILE_PIC+profilePic.getOriginalFilename());
				Files.write(path, byteArray);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!adharcard.isEmpty()) {
			try {
				byte[] byteArray= adharcard.getBytes();
				Path path=Paths.get(UPLOAD_MERCHANT_ADHARCARD+adharcard.getOriginalFilename());
				Files.write(path, byteArray);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		User existingMerchantUser = userRepositary.findById(Long.parseLong(merchantId)).orElse(null);
		existingMerchantUser.setProfilePic(UPLOAD_MERCHANT_PROFILE_PIC+profilePic.getOriginalFilename());
		existingMerchantUser.setAdharcard(UPLOAD_MERCHANT_ADHARCARD+adharcard.getOriginalFilename());
		return userRepositary.save(existingMerchantUser);
	}
	
}
