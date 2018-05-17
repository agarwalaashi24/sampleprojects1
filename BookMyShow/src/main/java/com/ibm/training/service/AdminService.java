package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.ibm.training.daoimpl.AdminDaoImpl;
import com.ibm.training.daoimpl.LoginDaoImpl;
import com.ibm.training.model.Login;
import com.ibm.training.model.Movie;
import com.ibm.training.model.Theatre;

@Service
public class AdminService {

    @Autowired
    AdminDaoImpl adminDaoImpl;
    
    @Autowired
    LoginDaoImpl loginDaoImpl;

    public void movieIn( Movie mv) {
        adminDaoImpl.movieInsert(mv);
    }

    public void theatreInsert(Theatre thr) {
        adminDaoImpl.theatreInsert(thr);
    }

    public void deleteMovie(String id) {
        adminDaoImpl.deleteMovie(id);
        
    }

    public List<Theatre> getAllTheatres() {
        return adminDaoImpl.fetchAllTheater();
    }

    public void deleteTheatre(String id) {
        adminDaoImpl.deleteTheatre(id);
    }

    public List<Movie> findAllMovies() {
    return adminDaoImpl.getAllMovies();
    }

    public void updateMovie(Movie m) {
    adminDaoImpl.updateMovie(m);
    } 
    
    public void updatetheatres(Theatre t) {
    adminDaoImpl.updateTheatre(t);

    }

    public Login loginA(String id,String password) {
        System.out.println("service"+id);
    return loginDaoImpl.valid_login(id, password);
        
    }

      
}
