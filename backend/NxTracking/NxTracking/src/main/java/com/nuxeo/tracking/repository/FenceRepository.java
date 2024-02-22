package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Fence;

@Repository
public interface FenceRepository extends JpaRepository<Fence, Long> { 

	@Query("SELECT o FROM Fence o INNER JOIN FETCH o.fenceGeometry WHERE o.id = :id AND o.dateDelete IS NULL")
	Fence findObjectId(Long id); 
	
	@Query("SELECT o FROM Fence o INNER JOIN FETCH o.fenceGeometry WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Fence> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Fence o INNER JOIN FETCH o.fenceGeometry WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Fence> findByCustomer(Long idCustomer); 

}