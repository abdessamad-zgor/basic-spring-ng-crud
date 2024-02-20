package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path="/users") 

public class MainController {
  @Autowired 
         
  private UserRepository userRepository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (
    @RequestParam String firstName
    ,@RequestParam String lastName
      , @RequestParam String email) {
    
    

    User n = new User();
    n.setFirstName(firstName);
    n.setLastName(lastName);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody List<User> getAllUsers() {
    // This returns a JSON or XML with the users
    List<User> users = userRepository.findAll();
    return users;
  }
}
