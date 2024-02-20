import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "../models/user.model";


@Injectable({
  providedIn: 'root'
})
export class UserService {
  serviceUrl = "http://localhost:8080/users"
  constructor(private http: HttpClient) {
    this.http = http
  }

  getAllUsers(){
    return this.http.get<User[]>(
      this.serviceUrl+"/all"
    )
  }
}
