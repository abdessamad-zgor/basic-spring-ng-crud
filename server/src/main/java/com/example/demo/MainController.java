package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping(path="/users") 

public class MainController {
  @Autowired 
         
  private UserRepository userRepository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (
    @RequestBody User user) {
    
    userRepository.save(user);
    return "Saved";
  }

  @PutMapping(path="{id}")

  @DeleteMapping(path="/{id}")
  public @ResponseBody String deleteUser(@PathVariable Integer id){
    Optional<User> result = userRepository.findById(id);
    if (result.isPresent()) {
      userRepository.delete(result.get());
      return "Success";
    }
    return "User not found.";
  }

  @GetMapping(path="/all")
  public @ResponseBody List<User> getAllUsers() {
    // This returns a JSON or XML with the users
    List<User> users = userRepository.findAll();
    return users;
  }
}
