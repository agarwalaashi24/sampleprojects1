package com.ibm.training.daoimpl;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ibm.training.model.Booking;
import com.ibm.training.model.Login;
import com.ibm.training.model.Movie;
import com.ibm.training.model.Theatre;

@Repository
public class UserDaoImpl {
    
    @Autowired
     JdbcTemplate jdbcTemplate;
    
    public void signupUser(Login login) {
    jdbcTemplate.update("insert into login values(?,?,?,?,?,?)", login.getId(),login.getName(), login.getPassword(), login.getRole(), login.getPh_no(), login.getEmail());
    System.out.println("User's values inserted");
        }
    
    public Collection<Movie> getAllMovies(){
    return jdbcTemplate.query("select * from movie",new BeanPropertyRowMapper<Movie>(Movie.class));
    }  
    
    public List<Theatre> findTheatre(String id){
    return jdbcTemplate.query("select * from theatre where m_id=?", new BeanPropertyRowMapper<Theatre>(Theatre.class),id);
    }
 
    public void bookTicket(Booking bk) {
    jdbcTemplate.update("insert into booking(tt_id) values(?)", bk.getTt_id());
    System.out.println("booking is done");
    }

}