package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlockJustify;

@Repository
public interface GroupBlockJustifyRepository extends JpaRepository<GroupBlockJustify, Long> { 

	@Query("SELECT o FROM GroupBlockJustify o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlockJustify findObjectId(Long id); 
	
	@Query("SELECT o FROM GroupBlockJustify o WHERE o.groupBlock.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlockJustify> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupBlockJustify o WHERE o.groupBlock.id = :idGroupBlock AND o.dateDelete IS NULL")
	List<GroupBlockJustify> findAllType(Long idGroupBlock); 

}