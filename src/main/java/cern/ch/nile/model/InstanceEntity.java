package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "instance", schema = "apiato")
@JsonPropertyOrder(alphabetic = true)
public class InstanceEntity {
    @Id
    @Column(name = "instance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("instance_id")
    private int id;

    @Basic
    @JsonProperty("username")
    private String owner;

    @Basic
    private String name;

    @Basic
    @Column(name = "e_group")
    @JsonProperty("e_group")
    private String egroup;

    @Basic
    @Enumerated(EnumType.STRING)
    private Category category;

    @Basic
    @Column(name = "creation_date")
    @JsonIgnore
    private Date creationDate;

    @Basic
    @Column(name = "expiry_date")
    @JsonIgnore
    private Date expiryDate;

    @Basic
    @JsonIgnore
    private Integer size;

    @Basic
    @Column(name = "no_connections")
    @JsonIgnore
    private Integer noConnections;

    @Basic
    private String project;

    @Basic
    private String description;

    @Basic
    private String version;

    @Basic
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private State state;

    @Basic
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Status status;

    @ManyToOne
    @JoinColumn(name = "master_instance_id", referencedColumnName = "instance_id")
    @JsonIgnore
    private InstanceEntity instanceByMasterInstanceId;

    @ManyToOne
    @JoinColumn(name = "slave_instance_id", referencedColumnName = "instance_id")
    @JsonIgnore
    private InstanceEntity instanceBySlaveInstanceId;

    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "host_id")
    @JsonIgnore
    private HostEntity host;

    @ManyToOne
    @JoinColumn(name = "cluster_id", referencedColumnName = "cluster_id")
    @JsonIgnore
    private ClusterEntity cluster;

    @OneToMany
    @JoinColumn(name = "instance_id", referencedColumnName = "instance_id")
    @JsonIgnore
    private Collection<VolumeEntity> volumes;

    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(schema = "apiato", name = "instance_attribute", joinColumns = @JoinColumn(name = "instance_id"))
    @JsonPropertyOrder(alphabetic = true)
    private Map<String, String> attributes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance_type_id")
    @JsonIgnore
    private InstanceTypeEntity instanceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstanceEntity that = (InstanceEntity) o;

        if (id != that.id) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (egroup != null ? !egroup.equals(that.egroup) : that.egroup != null) return false;
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
        result = 31 * result + (egroup != null ? egroup.hashCode() : 0);
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

    @JsonProperty("type")
    public String getType()

    {
        return instanceType.getType();
    }


}
