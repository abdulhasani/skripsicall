package com.jmat.skripsicall.master_data.service.query.api;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.user.repository.DatabaseQueryService;
import org.springframework.data.domain.Page;

import java.util.UUID;

/**
 * Created by Hasani on 6/2/2016.
 */
public interface FacultyQueryService extends DatabaseQueryService<Faculty> {
    public Page<Faculty> findByDeletedByIdIsNull(int page, int perPage);
    public Faculty findByIdAndDeletedByIdIsNull(UUID id);
    public Page<Faculty> findByNameFacultyAndDeletedByIdIsNull(int page,int perPage,String q);
}
