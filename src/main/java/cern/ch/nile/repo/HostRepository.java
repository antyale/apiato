package cern.ch.nile.repo;

import cern.ch.nile.model.ClusterEntity;
import cern.ch.nile.model.HostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
@Repository
public interface HostRepository extends CrudRepository<HostEntity, Long> {

    Collection<HostEntity> findAll();
    HostEntity findById(Long id);
    HostEntity findByName(String name);

}
