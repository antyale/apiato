package cern.ch.nile.repo;

import cern.ch.nile.model.ClusterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by aromerom on 29.05.17.
 */
@Repository
public interface ClusterRepository extends CrudRepository<ClusterEntity, Long> {
    ClusterEntity findById(Long id);

    ClusterEntity findByName(String clusterName);

    Collection<ClusterEntity> findAll();


}
