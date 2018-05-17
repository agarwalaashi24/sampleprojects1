package com.ibm.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.training.model.Login;
import com.ibm.training.service.UserService;

/*@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    
    @Autowired
    Login login;
    
    @RequestMapping("/home")
    public String getWelcome() {
        return "welcome";
    }
    
    @RequestMapping("/admin")
    public String getAdmin() {
        return "admin";
    }
    
    @RequestMapping("/movietheatre")
    public String getMoviethreatre() {
        return "movietheatre";
    }*/

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    Login login;
    @Autowired
    UserService  us;
    
    @RequestMapping("/")
    public String getWelcome() {
        return "welcome";
    }
    
    
    @RequestMapping(value="welcome",method=RequestMethod.POST)
    public ModelAndView welcome1(@RequestParam("choice") String choice) {
        ModelAndView mv = new ModelAndView();
        login.setRole(choice);

        if(choice.equals("admin")) {
            mv.setViewName("admin");

        }
        else {
            mv.setViewName("user");
             }
        return mv;
            }
}
