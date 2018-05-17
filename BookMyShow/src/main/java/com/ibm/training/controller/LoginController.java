package com.ibm.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.training.model.Login;
import com.ibm.training.service.LoginService;

@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @Autowired
    Login login;
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView authenticateUser(@RequestParam("id") String id,
            @RequestParam("password") String password) {
        
        System.out.println("contoller"+id);
        System.out.println(password);
        ModelAndView mv = new ModelAndView();
         login=loginService.login_valid(id, password);
    try {
        if(login!=null) {
            System.out.println("true");
        mv.setViewName("movietheatre");
            mv.addObject("message",login.getName());
        }
        else {
            System.out.println("false");
                mv.setViewName("admin");
                mv.addObject("message","Invalid Credentials");
        }
          
              
          }
    catch(Exception e) {
        System.out.println("false");
        mv.setViewName("admin");
        mv.addObject("message","Invalid Credentials");
    }
          return mv;
} 

}