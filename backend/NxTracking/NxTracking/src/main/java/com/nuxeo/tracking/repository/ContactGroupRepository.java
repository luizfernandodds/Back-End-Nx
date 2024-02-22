package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ContactGroup;

@Repository
public interface ContactGroupRepository extends JpaRepository<ContactGroup, Long> { 

	@Query("SELECT o FROM ContactGroup o WHERE o.id = :id AND o.dateDelete IS NULL")
	ContactGroup findObjectId(Long id); 
	
	@Query("SELECT o FROM ContactGroup o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ContactGroup> findByCompany(Long idCompany); 

	@Query("SELECT o FROM ContactGroup o WHERE o.customer.company.id = :idCompany AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ContactGroup> findByCompanyAndCustomer(Long idCompany, Long idCustomer); 

	@Query("SELECT o FROM ContactGroup o WHERE o.customer.company.id = :idCompany AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ContactGroup> findByCompanyLikeName(Long idCompany, String name); 

	@Query("SELECT o FROM ContactGroup o WHERE o.customer.company.id = :idCompany AND o.customer.id = :idCustomer AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ContactGroup> findByCompanyAndCustomerLikeName(Long idCompany, Long idCustomer, String name); 

}