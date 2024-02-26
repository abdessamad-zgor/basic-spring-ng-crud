package com.example.demo;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

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
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@Controller 
@RequestMapping(path="/users") 

public class MainController {
  @Autowired 
         
  private UserRepository userRepository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (
    @RequestBody User user) {
    System.out.println(user);
    
    userRepository.save(user);
    return "Saved";
  }

  @PutMapping(path="{id}")
  public @ResponseBody String updateUser(@PathVariable Integer id, @RequestBody User newUser){
    try {
      User userRefrence = userRepository.getReferenceById(id);

      userRefrence.setEmail(newUser.getEmail());
      userRefrence.setPhone(newUser.getPhone());
      userRefrence.setSalary(newUser.getSalary());
      userRefrence.setCountry(newUser.getCountry());
      userRefrence.setBirthday(newUser.getBirthday());
      userRefrence.setLastName(newUser.getLastName());
      userRefrence.setFirstName(newUser.getFirstName());

      userRepository.save(userRefrence);
      return "Success";
    } catch (EntityNotFoundException e) {
      return "User not found";
    }
  }

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
