package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CheckList;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Long> { 

	@Query("SELECT o FROM CheckList o WHERE o.id = :id AND o.dateDelete IS NULL")
	CheckList findObjectId(Long id); 
	
	@Query("SELECT o FROM CheckList o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<CheckList> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CheckList o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<CheckList> findByCompanyAndCustomer(Long idCustomer); 

}