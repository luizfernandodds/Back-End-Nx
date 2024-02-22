package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CostCenterKit;

@Repository
public interface CostCenterKitRepository extends JpaRepository<CostCenterKit, Long> { 

	@Query("SELECT o FROM CostCenterKit o WHERE o.id = :id AND o.dateDelete IS NULL")
	CostCenterKit findObjectId(Long id); 
	
	@Query("SELECT o FROM CostCenterKit o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKit> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CostCenterKit o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKit> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM CostCenterKit o WHERE o.customer.id = :idCustomer AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKit> findByCustomerAndDate(Long idCustomer, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM CostCenterKit o WHERE o.customer.company.id = :idCompany AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKit> findByCompanyAndDate(Long idCompany, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM CostCenterKit o WHERE o.id IN(:idList) AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKit> findByListId(List<Long> idList); 

}