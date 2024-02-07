package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Seller;

public interface SaleMinProjection {
	
	Long getId();
	Double getAmount();
	LocalDate getDate();
	String getSellerName();

}
