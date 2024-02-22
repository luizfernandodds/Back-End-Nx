package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlock;

@Repository
public interface GroupBlockRepository extends JpaRepository<GroupBlock, Long> { 

	@Query("SELECT o FROM GroupBlock o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlock findObjectId(Long id); 
	
	@Query("SELECT o FROM GroupBlock o WHERE o.typeBlockTarget.id = :idType AND o.active=true AND o.dateDelete IS NULL")
	List<GroupBlock> findAllType(Long idType); 

	@Query("SELECT o FROM GroupBlock o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlock> findByCompany(Long idCompany); 

	@Query("SELECT o FROM GroupBlock o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<GroupBlock> findByCustomer(Long idCustomer); 

}