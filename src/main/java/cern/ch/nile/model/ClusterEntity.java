package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cluster", schema = "apiato")
@JsonPropertyOrder(alphabetic = true)
public class ClusterEntity {

    @Id
    @Column(name = "cluster_id")
    @JsonProperty("cluster_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clusterId;

    @Basic
    @JsonProperty("username")
    private String owner;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "e_group")
    @JsonProperty("e_group")
    private String egroup;

    @Basic
    @JsonIgnore
    private Date creationDate;

    @Basic
    @JsonIgnore
    private Date expiryDate;

    @Basic
    private String project;

    @Basic
    private String description;

    @Basic
    private String version;

    @Basic
    @JsonProperty("lb_alias")
    private String lbAlias;

    @Enumerated(EnumType.STRING)
    private State state;

    @Enumerated(EnumType.STRING)
    @JsonProperty("class")
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(schema = "apiato", name = "cluster_attribute", joinColumns = @JoinColumn(name = "cluster_id"))
    @JsonPropertyOrder(alphabetic = true)
    private Map<String, String> attributes = new HashMap<String, String>();

    @OneToMany(mappedBy = "cluster")
    @JsonIgnore
    private Collection<InstanceEntity> instances;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClusterEntity that = (ClusterEntity) o;

        if (clusterId != that.clusterId) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (egroup != null ? !egroup.equals(that.egroup) : that.egroup != null) return false;
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
        int result = clusterId;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (egroup != null ? egroup.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (lbAlias != null ? lbAlias.hashCode() : 0);
        return result;
    }


    @JsonProperty("hosts")
    @Transient
    public Collection<String> getClusterHosts() {

        Collection<String> hosts = new ArrayList<>();
        for (InstanceEntity instance : this.instances) {
            hosts.add(instance.getHost().getName());
        }

        return hosts;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instance_type_id")
    @JsonIgnore
    private InstanceTypeEntity instanceType;

    @JsonProperty("type")
    public String getType()

    {
        return instanceType.getType();
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_cluster_id")
    @JsonIgnore
    private ClusterEntity masterCluster;
}
