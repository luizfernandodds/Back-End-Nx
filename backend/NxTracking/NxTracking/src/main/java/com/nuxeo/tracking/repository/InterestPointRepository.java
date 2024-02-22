package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.InterestPoint;

@Repository
public interface InterestPointRepository extends JpaRepository<InterestPoint, Long> { 

	@Query("SELECT o FROM InterestPoint o INNER JOIN FETCH o.interestPointGeometry WHERE o.id = :id AND o.dateDelete IS NULL")
	InterestPoint findObjectId(Long id); 
	
	@Query("SELECT o FROM InterestPoint o INNER JOIN FETCH o.interestPointGeometry WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<InterestPoint> findByCompany(Long idCompany); 

	@Query("SELECT o FROM InterestPoint o INNER JOIN FETCH o.interestPointGeometry WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<InterestPoint> findByCustomer(Long idCustomer); 

}