package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginManagerUnit;

@Repository
public interface LoginManagerUnitRepository extends JpaRepository<LoginManagerUnit, Long> { 

	@Query("SELECT o FROM LoginManagerUnit o WHERE o.id = :id")
	LoginManagerUnit findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginManagerUnit o WHERE o.login.id = :idLogin")
	List<LoginManagerUnit> findByLogin(Long idLogin); 

}