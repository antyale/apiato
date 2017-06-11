package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Map;

@Entity
@Table(name = "instance", schema = "apiato")
@JsonPropertyOrder(alphabetic = true)
public class InstanceEntity {
    private int id;
    private String owner;
    private String name;
    private String eGroup;
    private Category category;
    private Date creationDate;
    private Date expiryDate;
    private Integer size;
    private Integer noConnections;
    private String project;
    private String description;
    private String version;
    private State state;
    private Status status;
    private InstanceEntity instanceByMasterInstanceId;
    private InstanceEntity instanceBySlaveInstanceId;
    private HostEntity host;
    private ClusterEntity cluster;
    private Collection<VolumeEntity> volumes;
    private Map<String, String> attributes;

    @Id
    @Column(name = "instance_id")
    @JsonProperty("instance_id")
    public int getId() {
        return id;
    }

    public void setId(int instanceId) {
        this.id = instanceId;
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
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    @Column(name = "size")
    @JsonIgnore
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "no_connections")
    @JsonIgnore
    public Integer getNoConnections() {
        return noConnections;
    }

    public void setNoConnections(Integer noConnections) {
        this.noConnections = noConnections;
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
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstanceEntity that = (InstanceEntity) o;

        if (id != that.id) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (eGroup != null ? !eGroup.equals(that.eGroup) : that.eGroup != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (noConnections != null ? !noConnections.equals(that.noConnections) : that.noConnections != null)
            return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (eGroup != null ? eGroup.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (noConnections != null ? noConnections.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "master_instance_id", referencedColumnName = "instance_id")
    @JsonIgnore
    public InstanceEntity getInstanceByMasterInstanceId() {
        return instanceByMasterInstanceId;
    }

    public void setInstanceByMasterInstanceId(InstanceEntity instanceByMasterInstanceId) {
        this.instanceByMasterInstanceId = instanceByMasterInstanceId;
    }

    @ManyToOne
    @JoinColumn(name = "slave_instance_id", referencedColumnName = "instance_id")
    @JsonIgnore
    public InstanceEntity getInstanceBySlaveInstanceId() {
        return instanceBySlaveInstanceId;
    }

    public void setInstanceBySlaveInstanceId(InstanceEntity instanceBySlaveInstanceId) {
        this.instanceBySlaveInstanceId = instanceBySlaveInstanceId;
    }

    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "host_id")
    @JsonIgnore
    public HostEntity getHost() {
        return host;
    }

    public void setHost(HostEntity host) {
        this.host = host;
    }

    @ManyToOne
    @JoinColumn(name = "cluster_id", referencedColumnName = "cluster_id")
    @JsonBackReference
    public ClusterEntity getCluster() {
        return cluster;
    }

    public void setCluster(ClusterEntity cluster) {
        this.cluster = cluster;
    }


    @OneToMany
    @JoinColumn(name = "instance_id", referencedColumnName = "instance_id")
    public Collection<VolumeEntity> getVolumes() {
        return volumes;
    }

    public void setVolumes(Collection<VolumeEntity> volumes) {
        this.volumes = volumes;
    }

    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(schema = "apiato", name = "instance_attribute", joinColumns = @JoinColumn(name = "instance_id"))
    @JsonPropertyOrder(alphabetic = true)
    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
