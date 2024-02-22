package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoadType;

@Repository
public interface LoadTypeRepository extends JpaRepository<LoadType, Long> { 

	@Query("SELECT o FROM LoadType o WHERE o.id = :id AND o.dateDelete IS NULL")
	LoadType findObjectId(Long id); 
	
	@Query("SELECT o FROM LoadType o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<LoadType> findAllCompanyAndAttendance(Long idCompany); 

	@Query("SELECT o FROM LoadType o WHERE o.dateDelete IS NULL")
	List<LoadType> findAll(); 

}