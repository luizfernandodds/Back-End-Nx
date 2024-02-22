package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlockConfig;

@Repository
public interface GroupBlockConfigRepository extends JpaRepository<GroupBlockConfig, Long> { 

	@Query("SELECT o FROM GroupBlockConfig o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlockConfig findObjectId(Long id); 

	@Query("SELECT o FROM GroupBlockConfig o WHERE o.groupBlock.id = :idGroupBlock AND o.dateDelete IS NULL")
	List<GroupBlockConfig> findByGroupBlock(Long idGroupBlock); 

	@Query("SELECT o FROM GroupBlockConfig o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlockConfig> findAllCompany(Long idCompany); 

}