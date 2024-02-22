package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Kit;

@Repository
public interface KitRepository extends JpaRepository<Kit, Long> { 

	@Query("SELECT o FROM Kit o WHERE o.id = :id AND o.dateDelete IS NULL")
	Kit findObjectId(Long id); 
	
	@Query("SELECT o FROM Kit o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Kit> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Kit o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Kit> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM Kit o WHERE o.customer.company.id = :idCompany AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Kit> findByCompanyLikeName(Long idCompany, String name); 

	@Query("SELECT o FROM Kit o WHERE o.customer.id = :idCustomer AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Kit> findByCustomerLikeName(Long idCustomer, String name); 

}