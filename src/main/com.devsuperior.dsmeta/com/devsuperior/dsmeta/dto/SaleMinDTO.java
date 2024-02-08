package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleMinProjection;

public class SaleMinDTO {

	private Long id;
	private LocalDate date;
	private Double amount;
	private String sellerName;
	
	
	

	
	public SaleMinDTO(Long id, LocalDate date, Double amount, String sellerName) {
		
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.sellerName = sellerName;
	}

	public SaleMinDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
	}
	
	public SaleMinDTO(SaleMinProjection projection) {
		
		id = projection.getId();
		amount = projection.getAmount();
		date = projection.getDate();
		sellerName = projection.getSellerName();
		
	}


	public Long getId() {
		return id;
	}


	public Double getAmount() {
		return amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	@Override
	public String toString() {
		return "SaleMinDTO [id=" + id + ", amount=" + amount + ", date=" + date + ", sellerName=" + sellerName + "]";
	}
	

	
}
