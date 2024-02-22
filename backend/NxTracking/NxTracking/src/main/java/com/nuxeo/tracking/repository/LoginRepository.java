package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> { 

	@Query("SELECT o FROM Login o WHERE o.id = :id AND o.dateDelete IS NULL")
	Login findObjectId(Long id); 

	@Query("SELECT o FROM Login o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Login> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM Login o WHERE o.name = :name AND o.dateDelete IS NULL")
	Login findByName(String name); 

	@Query("SELECT o FROM Login o WHERE o.customer.id = :idCustomer AND  o.login = :login AND o.dateDelete IS NULL")
	Login findByLoginAndCustomer(String login, Long idCustomer); 

	@Query("SELECT o FROM Login o WHERE o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Login> findByNameLike(String name); 

	@Query("SELECT o FROM Login o WHERE o.dateDelete IS NULL ORDER BY o.id ASC")
	List<Login> findAll(String name); 
	
}