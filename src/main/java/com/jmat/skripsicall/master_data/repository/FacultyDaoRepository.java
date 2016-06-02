package com.jmat.skripsicall.master_data.repository;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.user.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * Created by Hasani on 6/1/2016.
 */
public interface FacultyDaoRepository extends BaseRepository<Faculty,UUID>{
    public Faculty findById(UUID id);
    public Page<Faculty> findByDeletedByIdIsNull(Pageable pageable);
    public Faculty findByIdAndDeletedByIdIsNull(UUID id);
    public Page<Faculty> findByNameFacultyLikeIgnoreCaseAndDeletedByIdIsNull(Pageable pageable,String q);
}
