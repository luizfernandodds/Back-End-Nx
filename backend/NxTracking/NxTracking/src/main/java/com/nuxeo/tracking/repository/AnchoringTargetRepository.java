package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AnchoringTarget;

@Repository
public interface AnchoringTargetRepository extends JpaRepository<AnchoringTarget, Long> { 

	@Query("SELECT o FROM AnchoringTarget o WHERE o.id = :id AND o.dateDelete IS NULL")
	AnchoringTarget findObjectId(Long id); 

	@Query("SELECT o FROM AnchoringTarget o WHERE o.idTarget = :idTarget AND o.dateDelete IS NULL")
	List<AnchoringTarget> findIdTarget(Long idTarget); 

	@Query("SELECT o FROM AnchoringTarget o WHERE o.anchoring.id = :idAnchoring AND o.dateDelete IS NULL")
	List<AnchoringTarget> findAnchoringId(Long idAnchoring); 

	@Query("SELECT o FROM AnchoringTarget o WHERE o.idTarget = :idTarget AND o.anchoring.id = :idAnchoring AND o.dateDelete IS NULL")
	List<AnchoringTarget> findAllAnchoringAndTarget(Long idAnchoring, Long idTarget); 

}