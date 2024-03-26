import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipment } from './equipment';

@Injectable({
  providedIn: 'any'
})
export class EquipmentService {

  private apiServerUrl: string;


  constructor(private http: HttpClient) {
    this.apiServerUrl = 'http://localhost:8080';
  }

  public getEquipments(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${this.apiServerUrl}/equipment/all`)

  }

  public addEquipment(equipment: Equipment): Observable<Equipment> {
    return this.http.post<Equipment>(`${this.apiServerUrl}/equipment/add`, equipment)
  }

  public updateEquipment(equipment: Equipment): Observable<Equipment> {
    return this.http.put<Equipment>(`${this.apiServerUrl}/equipment/update`, equipment)
  }

  public deleteEquipment(equipmentId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/equipment/update/${equipmentId}`)
  }



}
