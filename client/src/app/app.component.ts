import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DialogModule } from "primeng/dialog";
import { ButtonModule } from 'primeng/button';
import { TableComponent } from './table/table.component';
import { FormComponent } from './form/form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TableComponent, DialogModule, ButtonModule, FormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ng-crud';
  displayMessage="";
  dialogOpen: boolean = false;

  showDialog(){
    this.dialogOpen = true;
  }

  showResult(result: string){
    if(result.toLowerCase()=="success"){
      this.displayMessage = "Operation completed successfully."
    } else {
      this.displayMessage = "Something went wrong, "+result+", Try again later."
    }
  }
}
