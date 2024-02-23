import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DialogModule } from "primeng/dialog";
import { ButtonModule } from 'primeng/button';
import { TableComponent } from './table/table.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TableComponent, DialogModule, ButtonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ng-crud';
  dialogOpen = false;

  showDialog(){
    this.dialogOpen = true;
  }
}
