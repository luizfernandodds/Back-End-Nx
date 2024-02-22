package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginDriver;

@Repository
public interface LoginDriverRepository extends JpaRepository<LoginDriver, Long> { 

	@Query("SELECT o FROM LoginDriver o WHERE o.id = :id AND o.dateDelete IS NULL")
	LoginDriver findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginDriver o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.imei ASC")
	List<LoginDriver> findByCompany(Long idCompany); 

	@Query("SELECT o FROM LoginDriver o WHERE o.login.id = :idLogin AND o.dateDelete IS NULL ORDER BY o.imei ASC")
	List<LoginDriver> findByLogin(Long idLogin); 
	
	@Query("SELECT o FROM LoginDriver o WHERE o.driver.id = :idDriver AND o.dateDelete IS NULL ORDER BY o.imei ASC")
	List<LoginDriver> findByDriver(Long idDriver); 

}