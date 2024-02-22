package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlockException;

@Repository
public interface GroupBlockExceptionRepository extends JpaRepository<GroupBlockException, Long> { 

	@Query("SELECT o FROM GroupBlockException o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlockException findObjectId(Long id); 

	@Query("SELECT o FROM GroupBlockException o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlockException> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupBlockException o WHERE o.dateDelete IS NULL")
	List<GroupBlockException> findAll(); 

}