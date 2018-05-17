package com.ibm.training.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ibm.training.model.Movie;
import com.ibm.training.model.Theatre;
import com.ibm.training.service.AdminService;

@Controller
public class AdminController {
    @Autowired
    AdminService aservice;
    
    @Autowired
    Movie movie;
    
    @Autowired
    Theatre theatre;
    
    @RequestMapping("/movietheatre")
    public ModelAndView insertMovie(@RequestParam("choice") String choice) {
        ModelAndView mv= new ModelAndView();
        if(choice.equals("movie")) {
            mv.setViewName("movie");
            }
        else {
            mv.setViewName("theatre");
             }
        return mv;
             }
    @RequestMapping(value="/movie",method=RequestMethod.POST)
    public ModelAndView insertMovie1(@RequestParam("m_id") String m_id,@RequestParam("m_name") String m_name,
        @RequestParam("m_date") String m_date,@RequestParam("m_time") String m_time) {
        ModelAndView mv= new ModelAndView();
        movie.setM_id(m_id);
        movie.setM_name(m_name);
        movie.setM_date(m_date);
        movie.setM_time(m_time);
        aservice.movieIn(movie);
        mv.setViewName("movie");
        mv.addObject("message","Inserted Successfully");
        return mv;
        
    }
    
    @RequestMapping(value="/theatre",method=RequestMethod.POST)
    public ModelAndView insertTheatre(@RequestParam("t_id")String t_id,@RequestParam("t_name")String t_name,
            @RequestParam("seat_id") String seat_id,@RequestParam ("m_id")String m_id) {
        ModelAndView thr=new ModelAndView();
        theatre.setT_id(t_id);
        theatre.setT_name(t_name);
        theatre.setSeat_id(seat_id);
        theatre.setM_id(m_id);
        aservice.theatreInsert(theatre);
        thr.setViewName("theatre");
        thr.addObject("message","theatre is successfully inserted");
        return thr;
         
     }
    
    @RequestMapping("/delete/{id}")
    public void deleteMovie(@PathVariable ("id") String id) {
         aservice.deleteMovie(id);
    }
    
    @RequestMapping("/delete/theatre/{id}")
    public void deleteTheatre(@PathVariable ("id") String id) {
         aservice.deleteTheatre(id);
    }
    
    @RequestMapping("/all")
    public List<Theatre> getAllTheatre() {
    return aservice.getAllTheatres(); 
     }
    
    @RequestMapping("/all/movie")
    public List<Movie> getAll() {
    return aservice.findAllMovies(); 
     }
    
    @RequestMapping("/update")
    public void updateMovie(@RequestBody Movie m) {
        aservice.updateMovie(m);
    } 
    
    @RequestMapping("/update/theatre")
    public Theatre updateth(@RequestBody Theatre t) {
    aservice.updatetheatres(t);
        return t; 
     }   
    
    
    
    

}