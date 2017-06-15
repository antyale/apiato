package cern.ch.nile.repo;

import cern.ch.nile.model.HostEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

/**
 * Created by aromerom on 29.05.17.
 */
public interface HostRepository extends PagingAndSortingRepository<HostEntity, Integer> {

    Collection<HostEntity> findAll();
    HostEntity findById(int id);
    HostEntity findByName(String name);

}
