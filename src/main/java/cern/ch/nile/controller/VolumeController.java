package cern.ch.nile.controller;

import cern.ch.nile.model.ClusterEntity;
import cern.ch.nile.model.VolumeEntity;
import cern.ch.nile.repo.VolumeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "volumes", description = "Operations on volumes", tags = "volumes")
@RequestMapping("volumes")
public class VolumeController {

    @Autowired
    private VolumeRepository volumeRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all the volumes")
    public Collection<VolumeEntity> getAllVolumes() {
        return volumeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a new volume")
    public VolumeEntity addVolume(@RequestBody VolumeEntity input) {
        return volumeRepository.save(input);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a volume by id")
    public VolumeEntity getVolume(@PathVariable int id) {
        return volumeRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a volume by id")
    public void deleteVolume(@PathVariable int id) {
        volumeRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a volume")
    public VolumeEntity updateVolume(@PathVariable int id, @RequestBody VolumeEntity input) {
        input.setId(id);
        return volumeRepository.save(input);
    }

}
