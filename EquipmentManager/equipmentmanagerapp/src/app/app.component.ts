import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { Equipment } from './equipment';
import { EquipmentService } from './equipment.service';
import { HttpErrorResponse, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule, RouterLink, RouterLinkActive],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'Equipment Manager';

  public equipments: Equipment[] = [];

  constructor(private equipmentService: EquipmentService) { }


  ngOnInit() {
    this.getEquipments();
  }

  public getEquipments(): void {
    this.equipmentService.getEquipments().subscribe(
      (response: Equipment[]) => {
        this.equipments = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

}
