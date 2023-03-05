package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chicken")
public class Chicken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chicken_id")
	private Long chickenId;
	@Column(name = "desi")
	private Double desi;
	@Column(name = "liyor")
	private Double liyor;
	@Column(name = "banraj")
	private Double banraj;
	@Column(name = "broiler_boneless")
	private Double broilerBoneless;
	@Column(name = "broiler_skinless")
	private Double broilerSkinless;
	@Column(name = "broiler_leg_piece")
	private Double broilerLegPiece;
	@Column(name = "hechery")
	private Double hechery;
	@Column(name = "merchant_id")
	private Long merchantId;
	
	public Long getChickenId() {
		return chickenId;
	}
	public void setChickenId(Long chickenId) {
		this.chickenId = chickenId;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public Double getDesi() {
		return desi;
	}
	public void setDesi(Double desi) {
		this.desi = desi;
	}
	public Double getLiyor() {
		return liyor;
	}
	public void setLiyor(Double liyor) {
		this.liyor = liyor;
	}
	public Double getBanraj() {
		return banraj;
	}
	public void setBanraj(Double banraj) {
		this.banraj = banraj;
	}
	public Double getBroilerBoneless() {
		return broilerBoneless;
	}
	public void setBroilerBoneless(Double broilerBoneless) {
		this.broilerBoneless = broilerBoneless;
	}
	public Double getBroilerSkinless() {
		return broilerSkinless;
	}
	public void setBroilerSkinless(Double broilerSkinless) {
		this.broilerSkinless = broilerSkinless;
	}
	public Double getBroilerLegPiece() {
		return broilerLegPiece;
	}
	public void setBroilerLegPiece(Double broilerLegPiece) {
		this.broilerLegPiece = broilerLegPiece;
	}
	public Double getHechery() {
		return hechery;
	}
	public void setHechery(Double hechery) {
		this.hechery = hechery;
	}
	@Override
	public String toString() {
		return "Chicken [chickenId=" + chickenId + ", desi=" + desi + ", liyor=" + liyor + ", banraj=" + banraj
				+ ", broilerBoneless=" + broilerBoneless + ", broilerSkinless=" + broilerSkinless + ", broilerLegPiece="
				+ broilerLegPiece + ", hechery=" + hechery + ", merchantId=" + merchantId + "]";
	}
	
	
	

}
