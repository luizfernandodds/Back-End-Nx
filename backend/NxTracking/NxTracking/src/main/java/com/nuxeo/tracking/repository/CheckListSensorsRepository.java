package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CheckListSensors;

@Repository
public interface CheckListSensorsRepository extends JpaRepository<CheckListSensors, Long> { 

	@Query("SELECT o FROM CheckListSensors o WHERE o.id = :id AND o.dateDelete IS NULL")
	CheckListSensors findObjectId(Long id); 
	
	@Query("SELECT o FROM CheckListSensors o WHERE o.checklist.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<CheckListSensors> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CheckListSensors o WHERE o.checklist.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<CheckListSensors> findByCustomer(Long idCustomer); 

}