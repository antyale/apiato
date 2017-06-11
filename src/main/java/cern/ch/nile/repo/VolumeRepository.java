package cern.ch.nile.repo;

import cern.ch.nile.model.HostEntity;
import cern.ch.nile.model.VolumeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
@Repository
public interface VolumeRepository extends CrudRepository<VolumeEntity, Long> {

    Collection<VolumeEntity> findAll();
    VolumeEntity findByMountingPath(String mountingPath);
    VolumeEntity findById(Long id);
}
