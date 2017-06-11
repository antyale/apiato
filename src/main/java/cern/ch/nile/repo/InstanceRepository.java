package cern.ch.nile.repo;

import cern.ch.nile.model.InstanceEntity;
import cern.ch.nile.model.VolumeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
@Repository
public interface InstanceRepository extends CrudRepository<InstanceEntity, Long> {

    Collection<InstanceEntity> findAll();
    InstanceEntity findById(Long id);
}
