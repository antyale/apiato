package cern.ch.nile.repo;

import cern.ch.nile.model.VolumeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
public interface VolumeRepository extends PagingAndSortingRepository<VolumeEntity, Integer> {

    Collection<VolumeEntity> findAll();
    VolumeEntity findByMountingPath(String mountingPath);
    VolumeEntity findByVolumeId(int id);
}
