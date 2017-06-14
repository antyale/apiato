package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "volume", schema = "apiato")
@JsonPropertyOrder(alphabetic = true)
public class VolumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("volume_id")
    private int volumeId;

    @Basic
    @Column(length = 4)
    //@Column(name = "file_mode", length = 4, columnDefinition = "bpchar")
    @JsonProperty("file_mode")
    private String fileMode;

    @Basic
    @Column(name = "owner")
    @JsonProperty("owner")
    private String fileOwner;

    @Basic
    @JsonProperty("group")
    private String fileGroup;

    @Basic
    private String server;

    @Basic
    @Column(name = "mount_options")
    @JsonProperty("mount_options")
    private String mountOptions;

    @Basic
    @Column(name = "mounting_path")
    @JsonProperty("mounting_path")
    private String mountingPath;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volume_type_id")
    @JsonIgnore
    private VolumeTypeEntity volumeType;

    @Basic
    @Column(name = "instance_id")
    @JsonProperty("instance_id")
    private int instanceId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VolumeEntity that = (VolumeEntity) o;

        if (volumeId != that.volumeId) return false;
        if (fileMode != null ? !fileMode.equals(that.fileMode) : that.fileMode != null) return false;
        if (fileOwner != null ? !fileOwner.equals(that.fileOwner) : that.fileOwner != null) return false;
        if (fileGroup != null ? !fileGroup.equals(that.fileGroup) : that.fileGroup != null) return false;
        if (server != null ? !server.equals(that.server) : that.server != null) return false;
        if (mountOptions != null ? !mountOptions.equals(that.mountOptions) : that.mountOptions != null) return false;
        if (mountingPath != null ? !mountingPath.equals(that.mountingPath) : that.mountingPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = volumeId;
        result = 31 * result + (fileMode != null ? fileMode.hashCode() : 0);
        result = 31 * result + (fileOwner != null ? fileOwner.hashCode() : 0);
        result = 31 * result + (fileGroup != null ? fileGroup.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (mountOptions != null ? mountOptions.hashCode() : 0);
        result = 31 * result + (mountingPath != null ? mountingPath.hashCode() : 0);
        return result;
    }


//    @ElementCollection
//    @MapKeyColumn(name="name")
//    @Column(name = "value")
//    @CollectionTable(schema = "apiato", name="volume_attribute", joinColumns=@JoinColumn(name="volume_id"))
//    public Map<String, String> attributes = new HashMap<String, String>();

    @JsonProperty("volume_type")
    public String getType()

    {
        return volumeType.getType();
    }

}
