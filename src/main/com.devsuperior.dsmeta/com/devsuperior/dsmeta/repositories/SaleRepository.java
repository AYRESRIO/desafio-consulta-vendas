package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
@Query("SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj.id, obj.date, obj.amount, obj.seller.name) "
	    + "FROM Sale obj "
	    + "WHERE obj.date BETWEEN :minDate AND :maxDate "
	    + "AND UPPER(obj.seller.name) LIKE CONCAT('%', UPPER(:name), '%')")
Page<SaleMinDTO> searchReport(@Param("minDate")LocalDate minDate,
@Param("maxDate")LocalDate maxDate,@Param("name") String name, Pageable pageable);

}
