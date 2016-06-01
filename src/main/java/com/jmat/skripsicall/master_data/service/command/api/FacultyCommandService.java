package com.jmat.skripsicall.master_data.service.command.api;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.master_data.wrapper.FacultyWrapper;
import com.jmat.skripsicall.user.entity.User;
import com.jmat.skripsicall.user.repository.DatabaseSingleCommandService;

/**
 * Created by Hasani on 6/1/2016.
 */
public interface FacultyCommandService extends DatabaseSingleCommandService<Faculty>{
    public Faculty submit(FacultyWrapper facultyWrapper, User currentUser)throws Exception;
    public Faculty editSave(FacultyWrapper facultyWrapper,User currentUser);
    public Faculty remove(FacultyWrapper facultyWrapper);

}
