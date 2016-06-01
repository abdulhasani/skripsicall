package com.jmat.skripsicall.master_data.entity;

import com.jmat.skripsicall.support.entity.AbstractEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Hasani on 6/1/2016.
 */
@Entity
@Table(name = "mtd_faculty")
public class Faculty extends AbstractEntity{

    @Column(name = "nm_faculty",length = 65,nullable = false)
    private String nameFaculty;
    @Column(name = "count_prodi",length = 3,nullable = false)
    private Integer countProdi;

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public Integer getCountProdi() {
        return countProdi;
    }

    public void setCountProdi(Integer countProdi) {
        this.countProdi = countProdi;
    }
}
