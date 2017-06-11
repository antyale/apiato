package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aromerom on 26.05.17.
 */
@Entity
@Table(name = "cluster", schema = "apiato")
@JsonPropertyOrder(alphabetic=true)
public class ClusterEntity {

    private int id;
    private String owner;
    private String name;
    private String eGroup;
    private Date creationDate;
    private Date expiryDate;
    private String project;
    private String description;
    private String version;
    private String lbAlias;
    private State state;
    private Category category;
    private Status status;
    private Map<String, String> attributes = new HashMap<String, String>();
    private Collection<InstanceEntity> instances;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClusterEntity that = (ClusterEntity) o;

        if (id != that.id) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (eGroup != null ? !eGroup.equals(that.eGroup) : that.eGroup != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null) return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (lbAlias != null ? !lbAlias.equals(that.lbAlias) : that.lbAlias != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (eGroup != null ? eGroup.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (lbAlias != null ? lbAlias.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "cluster_id")
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int clusterId) {
        this.id = clusterId;
    }

    @Basic
    @Column(name = "owner")
    @JsonProperty("username")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
    @Column(name = "e_group")
    @JsonProperty("e_group")
    public String geteGroup() {
        return eGroup;
    }

    public void seteGroup(String eGroup) {
        this.eGroup = eGroup;
    }

    @Basic
    @Column(name = "creation_date")
    @JsonIgnore
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "expiry_date")
    @JsonIgnore
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Basic
    @Column(name = "project")
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "lb_alias")
    @JsonProperty("lb_alias")
    public String getLbAlias() {
        return lbAlias;
    }

    public void setLbAlias(String lbAlias) {
        this.lbAlias = lbAlias;
    }

    @Enumerated(EnumType.STRING)
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Enumerated(EnumType.STRING)
    @JsonProperty("class")
    @Column(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ElementCollection
    @MapKeyColumn(name="name")
    @Column(name = "value")
    @CollectionTable(schema = "apiato", name="cluster_attribute", joinColumns=@JoinColumn(name="cluster_id"))
    @JsonPropertyOrder(alphabetic=true)
    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }


    @OneToMany(mappedBy = "cluster")
    @JsonManagedReference
    public Collection<InstanceEntity> getInstances() {
        return instances;
    }

    public void setInstances(Collection<InstanceEntity> instances) {
        this.instances = instances;
    }


    @JsonProperty("hosts")
    @Transient
    public Collection<String> getClusterHosts(){

        Collection<String> hosts = new ArrayList<>();
        for (InstanceEntity instance : this.instances){
            hosts.add(instance.getHost().getName());
        }

        return hosts;
    }


}
