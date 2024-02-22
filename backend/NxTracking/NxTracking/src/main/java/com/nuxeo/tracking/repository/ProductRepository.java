package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { 

	@Query("SELECT o FROM Product o WHERE o.id = :id AND o.dateDelete IS NULL")
	Product findObjectId(Long id); 
	
	@Query("SELECT o FROM Product o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Product> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Product o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Product> findByCompanyAndCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Product o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Product> findAll(); 

}