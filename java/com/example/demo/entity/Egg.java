package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "egg")
public class Egg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "egg_id")
	private Long eggId;
	@Column(name = "large_egg")
	private Double largeEgg;
	@Column(name = "medium_egg")
	private Double mediumEgg;
	@Column(name = "small_egg")
	private Double smallEgg;
	@Column(name = "desi_egg")
	private Double desiEgg;
	@Column(name = "double_keshar_egg")
	private Double doublekesharEgg;
	@Column(name = "merchant_id")
	private Long merchantId;
	public Long getEggId() {
		return eggId;
	}
	public void setEggId(Long eggId) {
		this.eggId = eggId;
	}
	public Double getLargeEgg() {
		return largeEgg;
	}
	public void setLargeEgg(Double largeEgg) {
		this.largeEgg = largeEgg;
	}
	public Double getMediumEgg() {
		return mediumEgg;
	}
	public void setMediumEgg(Double mediumEgg) {
		this.mediumEgg = mediumEgg;
	}
	public Double getSmallEgg() {
		return smallEgg;
	}
	public void setSmallEgg(Double smallEgg) {
		this.smallEgg = smallEgg;
	}
	public Double getDesiEgg() {
		return desiEgg;
	}
	public void setDesiEgg(Double desiEgg) {
		this.desiEgg = desiEgg;
	}
	public Double getDoublekesharEgg() {
		return doublekesharEgg;
	}
	public void setDoublekesharEgg(Double doublekesharEgg) {
		this.doublekesharEgg = doublekesharEgg;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	@Override
	public String toString() {
		return "Egg [eggId=" + eggId + ", largeEgg=" + largeEgg + ", mediumEgg=" + mediumEgg + ", smallEgg=" + smallEgg
				+ ", desiEgg=" + desiEgg + ", doublekesharEgg=" + doublekesharEgg + ", merchantId=" + merchantId + "]";
	}
	
	
}
