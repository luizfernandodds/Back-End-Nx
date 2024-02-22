package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> { 

	@Query("SELECT o FROM Route o WHERE o.id = :id AND o.dateDelete IS NULL")
	Route findObjectId(Long id); 
	
	@Query("SELECT o FROM Route o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL AND o.idExternalRoute IS NULL ORDER BY o.name ASC")
	List<Route> findByCompanyAndCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Route o WHERE o.idExternalRoute IS NULL AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findAll(); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.idExternalRoute IS NULL AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Route o WHERE o.login.id = :idLogin AND o.idExternalRoute IS NULL AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByLogin(Long idLogin); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.id = :idRoute AND o.idExternalRoute IS NULL AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCustomerAndRoute(Long idCustomer, Long idRoute); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.id IN (:listRoute) AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCustomerAndRouteList(Long idCustomer, List<Long> listRoute); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.id IN (:listRoute) AND o.routeAlternate = :routeAlternate  AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCustomerAndRouteAlternate(Long idCustomer, List<Long> listRoute, Boolean routeAlternate); 

	@Query("SELECT o FROM Route o WHERE o.customer.company.id = :idCompany AND o.id IN (:listRoute) AND o.routeAlternate = :routeAlternate  AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCompanyAndRouteAlternate(Long idCompany, List<Long> listRoute, Boolean routeAlternate); 

	@Query("SELECT o FROM Route o WHERE o.login.id = :idLogin AND o.routeAlternate = :routeAlternate  AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByLoginAndRouteAlternate(Long idLogin, Boolean routeAlternate); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.routeAlternate = :routeAlternate  AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCustomerAndRouteAlternate(Long idCustomer, Boolean routeAlternate); 

	@Query("SELECT o FROM Route o WHERE o.customer.id = :idCustomer AND o.name LIKE %:name% AND o.routeAlternate = :routeAlternate AND o.routeType IN (2) AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Route> findByCustomerAndNameLike(Long idCustomer, String name, Boolean routeAlternate); 

	@Query("SELECT o FROM Route o WHERE o.idExternalRoute = :idExternalRoute AND o.dateDelete IS NULL ORDER BY o.id DESC")
	List<Route> findByIdExternalIntegration(Integer idExternalRoute); 

}
