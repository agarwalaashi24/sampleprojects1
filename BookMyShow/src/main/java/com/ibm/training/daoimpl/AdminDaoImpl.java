package com.ibm.training.daoimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.training.model.Login;
import com.ibm.training.model.Movie;
import com.ibm.training.model.Theatre;

@Repository
public class AdminDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    Login loginA;
    
    public void movieInsert(Movie mv) {
    jdbcTemplate.update("insert into movie values (?,?,?,?)",mv.getM_id(),mv.getM_name(),mv.getM_date(),mv.getM_time());
        }
    
    public void theatreInsert(Theatre th) {
    jdbcTemplate.update("insert into theatre(t_id,t_name,seat_id,m_id) values(?,?,?,?)",th.getT_id(),th.getT_name(),th.getSeat_id(),th.getM_id());
    }

    public List<Theatre> fetchAllTheater() {
    return jdbcTemplate.query("select * from theatre", new BeanPropertyRowMapper<Theatre>(Theatre.class));
    }

    public List<Movie> getAllMovies(){
    return jdbcTemplate.query("select * from movie", new BeanPropertyRowMapper<Movie>(Movie.class));
    }
    
    public void deleteMovie(String id) {
    jdbcTemplate.update("delete from movie where m_id=?",id);
        System.out.println("movie is deleted");
        }
    
    public void deleteTheatre(String id) {
    jdbcTemplate.update("delete from theatre where t_id=?",id);
    System.out.println("theatre is deleted");
    }
    
    public void updateMovie(Movie m) {
    jdbcTemplate.update("update movie set m_name=?, m_date=?, m_time=? where m_id=?", m.getM_name(), m.getM_date(), m.getM_time(),m.getM_id());
    }
    
    public void  updateTheatre(Theatre th) {
    jdbcTemplate.update("update theatre set t_name=?, seat_id=? where t_id=? ",th.getT_name(), th.getSeat_id(),
                th.getT_id());
    }
    }  