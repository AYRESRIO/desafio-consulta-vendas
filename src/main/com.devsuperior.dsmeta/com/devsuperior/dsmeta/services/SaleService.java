package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	public Page<SaleMinDTO>searchReport(String minDate, String maxDate, String name, Pageable pageable){
		
		LocalDate min = this.validateMinDate(minDate);
		LocalDate max = this.validateMaxDate(maxDate);
		
		return repository.searchReport(min, max, name, pageable);	
	}

	private LocalDate validateMaxDate(String maxDate) {
		LocalDate now = LocalDate.now(ZoneId.of("UTC"));
		
		if(maxDate!=null) {
		return maxDate.equals("")? now : LocalDate.parse(maxDate);
	}
		else { 
			return now;
			
		  }
			
		}

	private LocalDate validateMinDate(String minDate) {
		LocalDate now = LocalDate.now(ZoneId.of("UTC"));
		
		if(minDate != null) {
			return minDate.equals("")? now.minusDays(365): LocalDate.parse(minDate);
		}
		else { return now.minusDays(365);
		
	}
	
 }
	
}
