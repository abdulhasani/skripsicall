package com.jmat.skripsicall.support.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by User on 2/27/2016.
 */
@MappedSuperclass
public abstract class AbstractEntity implements IEntity {

    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "create_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "created_by_id", nullable = false)
    @Type(type="pg-uuid")
    @JsonProperty("created_by_id")
    private UUID createdById;

    @Column(name = "update_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by_id", nullable = false)
    @Type(type="pg-uuid")
    @JsonProperty("updated_by_id")
    private UUID updatedById;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("deleted_at")
    private Date deletedAt;

    @Column(name = "deleted_by_id")
    @Type(type="pg-uuid")
    @JsonProperty("deleted_by_id")
    private UUID deletedById;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createAt) {
        this.createdAt = createAt;
    }

    public UUID getCreatedById() {
        return createdById;
    }

    public void setCreatedById(UUID createdById) {
        this.createdById = createdById;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updateAt) {
        this.updatedAt = updateAt;
    }

    public UUID getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(UUID updatedById) {
        this.updatedById = updatedById;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedById() {
        return deletedById;
    }

    public void setDeletedById(UUID deletedById) {
        this.deletedById = deletedById;
    }

    @PrePersist
    void prePersist() {
        this.createdAt = this.updatedAt = new Date();
    }

    @PreUpdate
    void preUpdate() {
        this.updatedAt = new Date();
    }
}
