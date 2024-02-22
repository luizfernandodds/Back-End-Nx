package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CommandStatus;

@Repository
public interface CommandStatusRepository extends JpaRepository<CommandStatus, Long> { 

	@Query("SELECT o FROM CommandStatus o WHERE o.id = :id")
	CommandStatus findObjectId(Long id); 
	
	@Query("SELECT o FROM CommandStatus o INNER JOIN FETCH o.commandLog INNER JOIN FETCH o.commandStatusType  WHERE o.commandStatusType.id = 1 AND o.commandLog.id NOT IN (SELECT cs FROM CommandStatus cs WHERE cs.commandStatusType.id NOT IN (1,2,7,8)) ORDER BY o.dateCreate ASC")
	List<CommandStatus> findAllPending(); 
	
	@Query("SELECT o FROM CommandStatus o INNER JOIN FETCH o.commandLog INNER JOIN FETCH o.commandStatusType WHERE o.commandLog.device IN (:listDevice) AND o.commandStatusType.id = 1 AND o.commandLog.id NOT IN (SELECT cs.commandLog.id FROM CommandStatus cs WHERE cs.commandStatusType.id NOT IN (1,2,7,8)) ORDER BY o.dateCreate ASC")
	List<CommandStatus> findAllPendingByDeviceList(List<Long> listDevice); 

}