package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.KitService;

@Repository
public interface KitServiceRepository extends JpaRepository<KitService, Long> { 

	@Query("SELECT o FROM KitService o WHERE o.id = :id AND o.dateDelete IS NULL")
	KitService findObjectId(Long id); 
	
	@Query("SELECT o FROM KitService o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitService> findByCompany(Long idCompany); 

	@Query("SELECT o FROM KitService o WHERE o.customer.company.id = :idCompany AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitService> findByCompanyAndCustomer(Long idCompany, Long idCustomer); 

	@Query("SELECT o FROM KitService o WHERE o.customer.company.id = :idCompany AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitService> findByCompanyLikeName(Long idCompany, String name); 

	@Query("SELECT o FROM KitService o WHERE o.customer.id = :idCustomer AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitService> findByCustomerLikeName(Long idCustomer, String name); 

}