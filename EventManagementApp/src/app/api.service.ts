import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpclient: HttpClient) {

   }
  public getAllEmployees() {
    return this.httpclient.get("http://localhost:3000/employees");
  }
  public getEmployeeById(id:any) {
    return this.httpclient.get("http://localhost:3000/employees/" + id);
  }

  public deleteEmployeeById(id:any) {
    return this.httpclient.delete("http://localhost:3000/employees/" + id);
  }
  public addEmployee(emp:any) {
    return this.httpclient.post("http://localhost:3000/employees",emp);
  }
  public updateEmployee(emp:any) {
    return this.httpclient.put("http://localhost:3000/employees/"+ emp.Id,emp);
  }
}
