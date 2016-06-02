package com.jmat.skripsicall.master_data.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jmat.skripsicall.master_data.entity.Faculty;

import java.util.UUID;

/**
 * Created by Hasani on 6/1/2016.
 */
public class FacultyWrapper {
    private UUID id;
    private String nameFaculty;
    private Integer countProdi;

    public FacultyWrapper(Faculty entity) {
        initialAttribut(entity);
    }

    private void initialAttribut(Faculty entity){
        if(entity instanceof Faculty){
            id=entity.getId();
            nameFaculty=entity.getNameFaculty();
            countProdi=entity.getCountProdi();
        }
    }

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty("name_faculty")
    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    @JsonProperty("count_prodi")
    public Integer getCountProdi() {
        return countProdi;
    }

    public void setCountProdi(Integer countProdi) {
        this.countProdi = countProdi;
    }
}
