package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.BlockScheduleTarget;

@Repository
public interface BlockScheduleTargetRepository extends JpaRepository<BlockScheduleTarget, Long> { 

	@Query("SELECT o FROM BlockScheduleTarget o WHERE o.id = :id ")
	BlockScheduleTarget findObjectId(Long id); 
	
	@Query("SELECT o FROM BlockScheduleSent o WHERE o.customer.company.id = :idCompany AND o.blockSchedule.id = :idBlockSchedule ")
	List<BlockScheduleTarget> findByBlockScheduleAndCompany(Long idCompany, Long idBlockSchedule); 
	
	@Query("SELECT o FROM BlockScheduleSent o WHERE o.customer.id = :idCustomer AND o.blockSchedule.id = :idBlockSchedule ")
	List<BlockScheduleTarget> findByBlockScheduleAndCustomer(Long idCustomer, Long idBlockSchedule); 

	@Query("SELECT o FROM BlockScheduleTarget o WHERE o.target.id = :idTarget")
	List<BlockScheduleTarget> findAllByTarget(Long idTarget); 

}