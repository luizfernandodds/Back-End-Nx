package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.FuelControl;

@Repository
public interface FuelControlRepository extends JpaRepository<FuelControl, Long> { 

	@Query("SELECT o FROM FuelControl o WHERE o.id = :id AND o.dateDelete IS NULL")
	FuelControl findObjectId(Long id); 
	
	@Query("SELECT o FROM FuelControl o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.description ASC")
	List<FuelControl> findByCompany(Long idCompany); 

	@Query("SELECT o FROM FuelControl o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.description ASC")
	List<FuelControl> findByCustomer(Long idCustomer); 

}