package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ControlPoint;

@Repository
public interface ControlPointRepository extends JpaRepository<ControlPoint, Long> { 

	@Query("SELECT o FROM ControlPoint o INNER JOIN FETCH o.controlPointGeometry WHERE o.id = :id AND o.dateDelete IS NULL")
	ControlPoint findObjectId(Long id); 
	
	@Query("SELECT o FROM ControlPoint o INNER JOIN FETCH o.controlPointGeometry WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ControlPoint> findByCompany(Long idCompany); 

	@Query("SELECT o FROM ControlPoint o INNER JOIN FETCH o.controlPointGeometry WHERE o.customer.company.id = :idCompany AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ControlPoint> findByCompanyAndCustomer(Long idCompany, Long idCustomer); 

}