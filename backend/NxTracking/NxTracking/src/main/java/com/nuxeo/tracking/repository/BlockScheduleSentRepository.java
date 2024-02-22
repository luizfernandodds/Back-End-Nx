package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.BlockScheduleSent;

@Repository
public interface BlockScheduleSentRepository extends JpaRepository<BlockScheduleSent, Long> { 

	@Query("SELECT o FROM BlockScheduleSent o WHERE o.id = :id AND o.dateDelete IS NULL")
	BlockScheduleSent findObjectId(Long id); 
	
	@Query("SELECT o FROM BlockScheduleSent o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateSend ASC")
	List<BlockScheduleSent> findByCompany(Long idCompany); 

	@Query("SELECT o FROM BlockScheduleSent o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateSend ASC")
	List<BlockScheduleSent> findByCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM BlockScheduleSent o WHERE o.blockSchedule.id = :idBlockSchedule AND o.dateSend IS NULL AND o.sent = false AND o.dateDelete IS NULL")
	List<BlockScheduleSent> findByBlockSchedule(Long idBlockSchedule); 

	@Query("UPDATE BlockScheduleSent o SET o.dateDelete = current_date WHERE o.blockSchedule.id = :idBlockSchedule AND o.dateSend IS NULL AND o.sent = false")
	BlockScheduleSent cancelBlockSchedule(Long idBlockSchedule); 

}