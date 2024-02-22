package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.KitProduct;

@Repository
public interface KitProductRepository extends JpaRepository<KitProduct, Long> { 

	@Query("SELECT o FROM KitProduct o WHERE o.id = :id AND o.dateDelete IS NULL")
	KitProduct findObjectId(Long id); 
	
	@Query("SELECT o FROM KitProduct o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitProduct> findByCompany(Long idCompany); 

	@Query("SELECT o FROM KitProduct o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitProduct> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM KitProduct o WHERE o.customer.company.id = :idCompany AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitProduct> findByCompanyAndLikeName(Long idCompany, String name); 

	@Query("SELECT o FROM KitProduct o WHERE o.customer.id = :idCustomer AND o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<KitProduct> findByCustomerAndLikeName(Long idCustomer, String name); 

}