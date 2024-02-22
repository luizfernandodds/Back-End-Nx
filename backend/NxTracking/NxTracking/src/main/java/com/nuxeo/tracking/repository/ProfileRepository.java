package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> { 

	@Query("SELECT o FROM Profile o WHERE o.id = :id AND o.dateDelete IS NULL")
	Profile findObjectId(Long id); 
	
	@Query("SELECT o FROM Profile o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.i18n ASC")
	List<Profile> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Profile o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.i18n ASC")
	List<Profile> findByCustomer(Long idCustomer); 

	@Query("SELECT DISTINCT o FROM Profile o LEFT JOIN FETCH o.roles WHERE o.id >= :id AND o.customer.id IS NULL ORDER BY o.i18n")
	List<Profile> findByCompanyAndCustomer(Long id); 

	@Query("SELECT o FROM Profile o WHERE o.dateDelete IS NULL ORDER BY o.i18n ASC")
	List<Profile> findAll(); 

}