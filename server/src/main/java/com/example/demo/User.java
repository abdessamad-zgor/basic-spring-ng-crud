package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

import jakarta.persistence.Column;

@Entity
@Table(name="user")
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  private String birthday;

  private String country;

  private Double salary;

  private String email;

  private String phone;

  public Integer getId(){
    return this.id;
  }

  public void setId(Integer id){
    this.id = id;
  }

  public String getFirstName(){
    return this.firstName;
  }

  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  public String getLastName(){
    return this.lastName;
  }

  public void setLastName(String lastName){
    this.lastName = lastName;
  }

  public String getBirthday(){
    return this.birthday;
  }

  public void setBirthday(String birthday){
    this.birthday = birthday;
  }


  public String getCountry(){
    return this.country;
  }

  public void setCountry(String country){
    this.country = country;
  }

  public Double getSalary(){
    return this.salary;
  }

  public void setSalary(Double salary){
    this.salary = salary;
  }

  public String getEmail(){
    return this.email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getPhone(){
    return this.phone;
  }

  public void setPhone(String phone){
    this.phone = phone;
  }
}
