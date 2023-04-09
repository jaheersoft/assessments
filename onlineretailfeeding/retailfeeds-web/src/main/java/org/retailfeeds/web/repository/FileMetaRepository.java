package org.retailfeeds.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMetaRepository extends CrudRepository<org.retailfeeds.web.model.FileMeta, Integer> {
}
