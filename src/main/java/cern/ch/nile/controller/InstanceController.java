package cern.ch.nile.controller;

import cern.ch.nile.model.InstanceEntity;
import cern.ch.nile.model.VolumeEntity;
import cern.ch.nile.repo.InstanceRepository;
import cern.ch.nile.repo.VolumeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "instances", description = "Operations on instances", tags = "instances")
@RequestMapping("instances")
public class InstanceController {


    @Autowired
    private InstanceRepository instanceRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all the instances")
    public Collection<InstanceEntity> getAllInstances() {
        return instanceRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a new instance")
    public InstanceEntity addInstance(@RequestBody InstanceEntity input) {
        return instanceRepository.save(input);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a instance by id")
    public InstanceEntity getInstance(@PathVariable int id) {
        return instanceRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a instance by id")
    public void deleteInstance(@PathVariable int id) {
        instanceRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update an instance")
    public InstanceEntity updateInstance(@RequestBody InstanceEntity input) {
        return instanceRepository.save(input);
    }

}
