package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.daoimpl.LoginDaoImpl;
import com.ibm.training.model.Login;

@Service
public class LoginService {

    @Autowired
    LoginDaoImpl loginDaoImpl;
    
    public Login login_valid(String id,String password) {
        try {
        System.out.println("service");
        return loginDaoImpl.valid_login(id, password);
        }catch(Exception e){
            return null;
        }
    }
    
}