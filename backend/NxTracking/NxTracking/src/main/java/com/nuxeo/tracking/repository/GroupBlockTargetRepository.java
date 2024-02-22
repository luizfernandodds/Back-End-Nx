package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlockTarget;

@Repository
public interface GroupBlockTargetRepository extends JpaRepository<GroupBlockTarget, Long> { 

	@Query("SELECT o FROM GroupBlockTarget o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlockTarget findObjectId(Long id); 
	
	@Query("SELECT o FROM GroupBlockTarget o WHERE o.groupBlock.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlockTarget> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupBlockTarget o WHERE o.groupBlock.id = :idGroupBlock AND o.dateDelete IS NULL")
	List<GroupBlockTarget> findAllGroupBlock(Long idGroupBlock); 

}