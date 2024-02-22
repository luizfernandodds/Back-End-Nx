package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> { 

	@Query("SELECT o FROM Address o WHERE o.id = :id AND o.dateDelete IS NULL")
	Address findObjectId(Long id); 
}