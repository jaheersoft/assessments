package org.retailfeeds.web.repository;

import javax.transaction.Transactional;
import org.retailfeeds.web.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StoreRepository extends JpaRepository<Store, String> {

	Page<Store> findByProductNameContainingIgnoreCase(String keyword, Pageable pageable);

	//@Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
	//@Modifying
	//public void updatePublishedStatus(String id, boolean published);
}
