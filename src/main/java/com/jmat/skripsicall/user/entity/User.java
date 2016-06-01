package com.jmat.skripsicall.user.entity;

import com.jmat.skripsicall.support.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Hasani on 6/1/2016.
 */
@Entity
@Table(name = "sys_users")
public class User extends AbstractEntity{

    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "encrypted_password",nullable = false)
    private String encryptedPassword;
    @Column(name = "gcm_authToken")
    private String gcmAuthToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getGcmAuthToken() {
        return gcmAuthToken;
    }

    public void setGcmAuthToken(String gcmAuthToken) {
        this.gcmAuthToken = gcmAuthToken;
    }
}
