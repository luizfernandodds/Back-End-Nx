package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> { 

	@Query("SELECT o FROM Provider o WHERE o.id = :id AND o.dateDelete IS NULL")
	Provider findObjectId(Long id); 

	@Query("SELECT o FROM Provider o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Provider> findAll(); 

}