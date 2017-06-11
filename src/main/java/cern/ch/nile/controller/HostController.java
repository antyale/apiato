package cern.ch.nile.controller;

import cern.ch.nile.model.HostEntity;
import cern.ch.nile.model.InstanceEntity;
import cern.ch.nile.repo.HostRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by aromerom on 26.03.17.
 */
@RestController
@Api(value = "hosts", description = "Operations on hosts", tags = "hosts")
@RequestMapping("hosts")
public class HostController {


    @Autowired
    private HostRepository hostRepository;

    @ApiOperation(value = "Get all hosts")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<HostEntity> getAllHosts() {
        return hostRepository.findAll();
    }

    @ApiOperation(value = "Add a new host")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public HostEntity addHost(@RequestBody HostEntity input) {
        return hostRepository.save(input);
    }


    @ApiOperation(value = "Find a host by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HostEntity getVolume(@PathVariable Long id) {
        return hostRepository.findById(id);
    }

    @ApiOperation(value = "Delete a host by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVolume(@PathVariable Long id) {
        hostRepository.delete(id);
    }

    @ApiOperation(value = "Return the host metadata. Includes the instances for that host")
    @RequestMapping(value = "/{hostname}/metadata", method = RequestMethod.GET)
    public Collection<InstanceEntity> getHostMetadata(@PathVariable String hostname) {

        HostEntity host = hostRepository.findByName(hostname);

        if (host == null) return new ArrayList<>();

        return host.getInstances();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a host")
    public HostEntity updateHost(@RequestBody HostEntity input) {
        return hostRepository.save(input);
    }

}
