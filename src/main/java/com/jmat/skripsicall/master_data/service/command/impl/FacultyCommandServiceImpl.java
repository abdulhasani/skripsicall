package com.jmat.skripsicall.master_data.service.command.impl;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.master_data.repository.FacultyDaoRepository;
import com.jmat.skripsicall.master_data.service.command.api.FacultyCommandService;
import com.jmat.skripsicall.master_data.wrapper.FacultyWrapper;
import com.jmat.skripsicall.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Hasani on 6/1/2016.
 */
@Service("facultyCommandServiceImpl")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class FacultyCommandServiceImpl implements FacultyCommandService {

    @Autowired
    private FacultyDaoRepository facultyDaoRepository;

    @Override
    public Faculty submit(FacultyWrapper facultyWrapper, User currentUser) throws Exception {
        if (facultyWrapper == null) {
            return null;
        }
        Faculty faculty = new Faculty();
        faculty.setNameFaculty(facultyWrapper.getNameFaculty());
        faculty.setCountProdi(facultyWrapper.getCountProdi());
        return save(faculty, currentUser);
    }

    @Override
    public Faculty editSave(Faculty entity, User currentUser) {
        entity.setUpdatedById(currentUser.getId());
        entity.setUpdatedAt(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return save(entity);
    }

    @Override
    public void remove(Faculty entity) {
        facultyDaoRepository.remove(entity);
    }

    @Override
    public Faculty save(Faculty entity) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() == null) {
            entity.setCreatedAt(new Date());
        }
        entity.setUpdatedAt(new Date());
        return facultyDaoRepository.save(entity);
    }

    @Override
    public Faculty save(Faculty entity, User user) throws Exception {
        if (entity == null || user == null) {
            return null;
        }
        if (entity.getId() == null) {
            entity.setCreatedById(user.getId());
        }
        entity.setUpdatedById(user.getId());
        return save(entity);
    }

    @Override
    public boolean delete(Faculty entity) {
        if (entity == null) {
            return false;
        }
        entity.setDeletedAt(new Date());
        return save(entity) != null ? true : false;
    }

    @Override
    public boolean delete(Faculty entity, User user) {
        if(entity==null||user==null){
            return false;
        }
        entity.setDeletedById(user.getId());
        return delete(entity);
    }

    @Override
    public boolean restore(Faculty entity) {
        return false;
    }

    @Override
    public boolean restore(Faculty entity, User user) {
        return false;
    }
}
