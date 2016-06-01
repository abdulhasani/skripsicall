package com.jmat.skripsicall.master_data.service.command.impl;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.master_data.service.command.api.FacultyCommandService;
import com.jmat.skripsicall.master_data.wrapper.FacultyWrapper;
import com.jmat.skripsicall.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hasani on 6/1/2016.
 */
@Service("facultyCommandServiceImpl")
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class FacultyCommandServiceImpl implements FacultyCommandService{

    @Override
    public Faculty submit(FacultyWrapper facultyWrapper, User currentUser) throws Exception {
        return null;
    }

    @Override
    public Faculty editSave(FacultyWrapper facultyWrapper, User currentUser) {
        return null;
    }

    @Override
    public Faculty remove(FacultyWrapper facultyWrapper) {
        return null;
    }

    @Override
    public Faculty save(Faculty entity) {
        return null;
    }

    @Override
    public Faculty save(Faculty entity, User user) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Faculty entity) {
        return false;
    }

    @Override
    public boolean delete(Faculty entity, User user) {
        return false;
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
