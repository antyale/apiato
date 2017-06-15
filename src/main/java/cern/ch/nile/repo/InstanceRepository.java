package cern.ch.nile.repo;

import cern.ch.nile.model.InstanceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
public interface InstanceRepository extends PagingAndSortingRepository<InstanceEntity, Integer> {

    Collection<InstanceEntity> findAll();
    InstanceEntity findById(int id);
}
