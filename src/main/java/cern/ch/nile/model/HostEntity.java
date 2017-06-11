package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "host", schema = "apiato")
@JsonPropertyOrder(alphabetic=true)
public class HostEntity {
    private int id;
    private String name;
    private int memory;
    private Collection<InstanceEntity> instances;

    @Id
    @Column(name = "host_id")
    public int getId() {
        return id;
    }

    public void setId(int hostId) {
        this.id = hostId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "memory")
    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostEntity that = (HostEntity) o;

        if (id != that.id) return false;
        if (memory != that.memory) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + memory;
        return result;
    }

    @OneToMany(mappedBy = "host")
    @JsonIgnore
    public Collection<InstanceEntity> getInstances() {
        return instances;
    }

    public void setInstances(Collection<InstanceEntity> instances) {
        this.instances = instances;
    }
}
