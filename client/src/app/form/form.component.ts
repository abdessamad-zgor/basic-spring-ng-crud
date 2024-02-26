import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../services/user.service';
import { createUser } from '../models/user.model';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss'
})

export class FormComponent {
  pending = false;
  model = createUser();
  @Output() resultEvent = new EventEmitter<string>()

  constructor(private userService: UserService){}

  submitUser(){
    this.pending=true;
    console.log()
    this.userService.addUser(this.model).subscribe(response=>{
      this.pending = false
      this.displayResult(response)
    })
  }

  displayResult(result: string){
    this.resultEvent.emit(result)
  }
}
