package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.RcVehicleAnalysis;

@Repository
public interface RcVehicleAnalysisRepository extends JpaRepository<RcVehicleAnalysis, Long> { 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.id = :id AND o.dateDelete IS NULL")
	RcVehicleAnalysis findObjectId(Long id); 
	
	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<RcVehicleAnalysis> findByCompany(Long idCompany); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<RcVehicleAnalysis> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.dateDelete IS NULL")
	List<RcVehicleAnalysis> findAll(); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.loginCreate = :idLogin AND o.dateDelete IS NULL")
	List<RcVehicleAnalysis> findByLogin(Long idLogin); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.dateReturnAnalysis IS NULL AND o.dateDelete IS NULL")
	List<RcVehicleAnalysis> findByReturnAnalysis(); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.plate = :plate AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<RcVehicleAnalysis> findAllByDateAndPlate(String plate, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<RcVehicleAnalysis> findByDate(LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL GROUP BY o.createTimeMillisecond ORDER BY o.dateCreate DESC")
	List<RcVehicleAnalysis> findByDateGroupByCreateMilli(LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.plate = :plate AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.createTimeMillisecond = :createTimeMillisecond AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<RcVehicleAnalysis> findByDateAndPlateAndCreateMilli(String plate, LocalDateTime begin, LocalDateTime end, Long createTimeMillisecond); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.customer.id = :idCustomer AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL GROUP BY o.createTimeMillisecond  ORDER BY o.dateCreate DESC")
	List<RcVehicleAnalysis> findByDateAndCustomerGroupByCreateMilli(Long idCustomer, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcVehicleAnalysis o WHERE o.customer.id = :idCustomer AND o.dateCreate >= :begin AND o.dateCreate <= :end GROUP BY o.createTimeMillisecond ORDER BY o.dateCreate DESC")
	List<RcVehicleAnalysis> findByDateAndDocumentGroupByCreateMilliAndCustomer(Long idCustomer, LocalDateTime begin, LocalDateTime end); 

}