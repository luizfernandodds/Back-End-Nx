package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupControl;

@Repository
public interface GroupControlRepository extends JpaRepository<GroupControl, Long> { 

	@Query("SELECT o FROM GroupControl o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupControl findObjectId(Long id); 
	
	@Query("SELECT o FROM GroupControl o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupControl> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupControl o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<GroupControl> findAllCustomer(Long idCustomer); 

	@Query("SELECT o FROM GroupControl o WHERE o.customer.id = :idCustomer AND o.type = :type AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<GroupControl> findAllCustomer(Long idCustomer, Integer type); 

}