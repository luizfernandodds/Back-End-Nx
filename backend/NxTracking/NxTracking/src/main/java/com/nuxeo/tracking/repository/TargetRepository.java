package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Target;

@Repository
public interface TargetRepository extends JpaRepository<Target, Long> { 

	@Query("SELECT o FROM Target o WHERE o.id = :id AND o.dateDelete IS NULL")
	Target findObjectId(Long id); 

	@Query("SELECT o FROM Target o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<Target> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM Target o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<Target> findAllCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM Target o WHERE o.customer.company.id = :idCompany AND o.identifier = :identifier AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<Target> findByCompanyAndIdentifier(Long idCompany, String identifier); 

	@Query("SELECT o FROM Target o WHERE o.customer.company.id = :idCompany AND o.identifier LIKE %:identifier% AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<Target> findByCompanyAndLikeIdentifier(Long idCompany, String identifier); 

	@Query("SELECT o FROM Target o WHERE o.customer.id = :idCustomer AND o.identifier = :identifier AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<Target> findByCustomerAndIdentifier(Long idCustomer, String identifier); 

	@Query("SELECT o FROM Target o WHERE o.customer.id = :idCustomer AND o.identifier LIKE %:identifier% AND o.dateDelete IS NULL ORDER BY o.identifier ASC")
	List<Target> findByCustomerAndLikeIdentifier(Long idCustomer, String identifier); 

}