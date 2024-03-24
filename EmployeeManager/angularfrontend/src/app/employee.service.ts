import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './employee';
import { Observable } from 'rxjs';

@Injectable()
export class EmployeeService {

  private employeeUrl: string;

  constructor(private http: HttpClient) {
    this.employeeUrl = 'http://localhost:8080/employee';
  }

  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeeUrl);
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(this.employeeUrl, Employee);
  }
}