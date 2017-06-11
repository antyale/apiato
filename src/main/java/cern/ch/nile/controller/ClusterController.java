package cern.ch.nile.controller;

import cern.ch.nile.model.ClusterEntity;
import cern.ch.nile.repo.ClusterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by aromerom on 26.03.17.
 */
@RestController
@RequestMapping("clusters")
@Api(value = "clusters", description = "Operations on clusters", tags = "clusters")
public class ClusterController {

    @Autowired
    private ClusterRepository clusterRepository;


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all the clusters")
    public Collection<ClusterEntity> getAllCluster() {
        return clusterRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a new cluster")
    public ClusterEntity addCluster(@RequestBody ClusterEntity input) {
        return clusterRepository.save(input);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a cluster by id")
    public ClusterEntity getClusterById(@PathVariable Long id) {
        return clusterRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a cluster by id")
    public void deleteCluster(@PathVariable Long id) {
        clusterRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a cluster")
    public ClusterEntity updateCluster(@RequestBody ClusterEntity input) {
        return clusterRepository.save(input);
    }


}
