package com.jmat.skripsicall.master_data.service.query.impl;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.master_data.repository.FacultyDaoRepository;
import com.jmat.skripsicall.master_data.service.query.api.FacultyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Hasani on 6/2/2016.
 */
@Service
@Transactional(readOnly = true)
public class FacultyQueryServiceImpl implements FacultyQueryService{

    @Autowired
    private FacultyDaoRepository facultyDaoRepository;

    @Override
    public Page<Faculty> findByDeletedByIdIsNull(int page, int perPage) {
        return facultyDaoRepository.findByDeletedByIdIsNull(new PageRequest(page-1,perPage,new Sort(Sort.Direction.DESC,"createdAt")));
    }

    @Override
    public Faculty findByIdAndDeletedByIdIsNull(UUID id) {
        return facultyDaoRepository.findByIdAndDeletedByIdIsNull(id);
    }

    @Override
    public Page<Faculty> findByNameFacultyAndDeletedByIdIsNull(int page, int perPage,String q) {
        return facultyDaoRepository.findByNameFacultyLikeIgnoreCaseAndDeletedByIdIsNull(new PageRequest(page - 1, perPage, new Sort(Sort.Direction.DESC, "createdAt")), q);
    }

    @Override
    public Faculty findById(UUID id) {
        return facultyDaoRepository.findById(id);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyDaoRepository.findAll();
    }
}
