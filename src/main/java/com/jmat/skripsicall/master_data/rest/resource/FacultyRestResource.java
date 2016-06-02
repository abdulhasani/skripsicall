package com.jmat.skripsicall.master_data.rest.resource;

import com.jmat.skripsicall.master_data.entity.Faculty;
import com.jmat.skripsicall.master_data.service.command.api.FacultyCommandService;
import com.jmat.skripsicall.master_data.service.query.api.FacultyQueryService;
import com.jmat.skripsicall.master_data.wrapper.FacultyWrapper;
import com.jmat.skripsicall.support.Notification;
import com.jmat.skripsicall.support.transfer.ArrayTransfer;
import com.jmat.skripsicall.support.wrapper.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hasani on 6/2/2016.
 */
@Component
@Path("/master-data/faculty")
public class FacultyRestResource {

    private static final Logger LOG= LoggerFactory.getLogger(FacultyRestResource.class);

    @Autowired
    private FacultyCommandService facultyCommandService;
    @Autowired
    private FacultyQueryService facultyQueryService;

    @GET
    @Path("/facultys")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public ResponseWrapper<ArrayTransfer<FacultyWrapper>> getFacultys(@QueryParam("page") int page,
                                                                      @QueryParam("per_page")int perPage,
                                                                      @QueryParam("filter_param") String nameFaculty){
        ResponseWrapper<ArrayTransfer<FacultyWrapper>> response=new ResponseWrapper<>();
        ArrayTransfer<FacultyWrapper> responseArray=new ArrayTransfer<FacultyWrapper>(FacultyWrapper.class);
        String paramter="%%";
        if(nameFaculty!=null){
            if(!nameFaculty.trim().isEmpty()){
                paramter="%"+nameFaculty+"%";
            }
        }
        Page<Faculty> facultys = facultyQueryService.findByNameFacultyAndDeletedByIdIsNull(page, perPage, paramter);
        Notification notif;
        if(!facultys.getContent().isEmpty()){
            notif=new Notification("success","200");
            for (Faculty fc:facultys){
                FacultyWrapper fcWrapper=new FacultyWrapper(fc);
                responseArray.addItem(fcWrapper);
            }
        }else{
            notif=new Notification("data faculty not found","400");
        }
        List<Notification> listNotif=new ArrayList<>();
        listNotif.add(notif);
        response.setNotifications(listNotif);
        response.setData(responseArray);
        return response;
    }
}
