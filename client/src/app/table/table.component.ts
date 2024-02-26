import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';
import {TableModule} from "primeng/table";
import { UserService } from '../services/user.service';
import { User } from '../models/user.model';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [TableModule, NgFor, ButtonModule],
  templateUrl: './table.component.html',
  styleUrl: './table.component.scss'
})
export class TableComponent implements OnInit {
  users: User[] = []
  constructor(private userService: UserService){
  }

  ngOnInit(){
    this.userService.getAllUsers().subscribe(data=>{
      this.users = [...data]
    })
  }
}
