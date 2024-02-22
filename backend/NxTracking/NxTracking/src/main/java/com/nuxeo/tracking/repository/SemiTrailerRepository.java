package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SemiTrailer;

@Repository
public interface SemiTrailerRepository extends JpaRepository<SemiTrailer, Long> { 

	@Query("SELECT o FROM SemiTrailer o WHERE o.id = :id AND o.dateDelete IS NULL")
	SemiTrailer findObjectId(Long id); 

	@Query("SELECT o FROM SemiTrailer o WHERE o.dateDelete IS NULL ORDER BY o.identifier ASC")
	SemiTrailer findAllOrderIdentifier(); 

	@Query("SELECT o FROM SemiTrailer o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	SemiTrailer findAllOrderIdentifierByCustomer(Long idCustomer); 

	@Query("SELECT o FROM SemiTrailer o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	SemiTrailer findAllOrderIdentifierByCompany(Long idCompany); 

	@Query("SELECT o FROM SemiTrailer o WHERE o.identifier LIKE %:identifier% AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<SemiTrailer> findByCustomerAndNameLike(String identifier, Long idCustomer); 

	@Query("SELECT o FROM SemiTrailer o WHERE o.identifier LIKE %:identifier% AND o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<SemiTrailer> findByCompanyAndNameLike(String identifier, Long idCompany); 

}