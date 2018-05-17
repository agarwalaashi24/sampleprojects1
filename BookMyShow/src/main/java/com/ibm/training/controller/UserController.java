package com.ibm.training.controller;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ibm.training.model.Booking;
import com.ibm.training.model.Login;
import com.ibm.training.model.Movie;
import com.ibm.training.model.Theatre;
import com.ibm.training.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService uservice;

    @RequestMapping("/insert")
    public Login insertPerson(@RequestBody Login l) {
    uservice.signUpUser(l);
    return l;
    }
    
    @RequestMapping("/all")
    public Collection<Movie> getAll(){
    return uservice.findAllMovies();
    }
    
    @RequestMapping("/gettheatre/{id}")
    public List<Theatre> getTheatre(@PathVariable("id") String id) {
    return uservice.theatreFind(id);
    }
    
    @RequestMapping("/book")
    public void BookingTickets(@RequestBody Booking bk) {
        uservice.bookingTickets(bk);
    }
    
    
}