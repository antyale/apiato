package cern.ch.nile.repo;

import cern.ch.nile.model.ClusterEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
public interface ClusterRepository extends PagingAndSortingRepository<ClusterEntity, Integer> {
    ClusterEntity findByClusterId(int id);

    ClusterEntity findByName(String clusterName);

    Collection<ClusterEntity> findAll();


}
