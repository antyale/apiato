package cern.ch.nile.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@Table(name = "volume", schema = "apiato")
@JsonPropertyOrder(alphabetic=true)
public class VolumeEntity {
    private int id;
    private String fileMode;
    private String owner;
    private String group;
    private String server;
    private String mountOptions;
    private String mountingPath;
    private int volumeTypeId;
    private int instanceId;

    @Id
    @Column(name = "volume_id")
    @JsonProperty("volume_id")
    public int getId() {
        return id;
    }

    public void setId(int volumeId) {
        this.id = volumeId;
    }

    @Basic
    @Column(name = "file_mode", length=4, columnDefinition = "bpchar")
    @JsonProperty("file_mode")
    public String getFileMode() {
        return fileMode;
    }

    public void setFileMode(String fileMode) {
        this.fileMode = fileMode;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Basic
    @Column(name = "server")
    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Basic
    @Column(name = "mount_options")
    @JsonProperty("mount_options")
    public String getMountOptions() {
        return mountOptions;
    }

    public void setMountOptions(String mountOptions) {
        this.mountOptions = mountOptions;
    }

    @Basic
    @Column(name = "mounting_path")
    @JsonProperty("mounting_path")
    public String getMountingPath() {
        return mountingPath;
    }

    public void setMountingPath(String mountingPath) {
        this.mountingPath = mountingPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VolumeEntity that = (VolumeEntity) o;

        if (id != that.id) return false;
        if (fileMode != null ? !fileMode.equals(that.fileMode) : that.fileMode != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (server != null ? !server.equals(that.server) : that.server != null) return false;
        if (mountOptions != null ? !mountOptions.equals(that.mountOptions) : that.mountOptions != null) return false;
        if (mountingPath != null ? !mountingPath.equals(that.mountingPath) : that.mountingPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fileMode != null ? fileMode.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
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


    @Basic
    @Column(name = "volume_type_id")
    @JsonProperty("volume_type_id")
    public int getVolumeTypeId() {
        return volumeTypeId;
    }

    public void setVolumeTypeId(int volumeTypeId) {
        this.volumeTypeId = volumeTypeId;
    }

    @Basic
    @Column(name = "instance_id")
    @JsonProperty("instance_id")
    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }
}
