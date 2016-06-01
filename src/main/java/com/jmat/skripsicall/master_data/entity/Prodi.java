package com.jmat.skripsicall.master_data.entity;

import com.jmat.skripsicall.support.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Hasani on 6/1/2016.
 */
@Entity
@Table(name = "mtd_prodi")
public class Prodi extends AbstractEntity{
    @Column(name = "nm_prodi",length = 65)
    private String nameProdi;

    public String getNameProdi() {
        return nameProdi;
    }

    public void setNameProdi(String nameProdi) {
        this.nameProdi = nameProdi;
    }
}
