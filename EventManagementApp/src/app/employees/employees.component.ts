import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { UntypedFormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  sampleData: any
  userTable:boolean = true
  employeeForm:any;

  constructor(private fb: UntypedFormBuilder,private api: ApiService, private router:Router) { 
    this.employeeForm = this.fb.group({
      id: ['', [Validators.required]],
      first_name: ['', [Validators.required]],
      last_name: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.api.getAllEmployees().subscribe((data)=>{
      console.log(data);
      this.sampleData=data;   
     }); 
  }
  onEmpBtnClick(){
    var emp = new Employee();
    emp.Id=this.employeeForm.controls['id'].value;
    emp.first_name=this.employeeForm.controls['first_name'].value;
    emp.last_name=this.employeeForm.controls['last_name'].value;
    emp.email=this.employeeForm.controls['email'].value;
    this.api.addEmployee(emp).subscribe((data)=>{
      console.log(data);
      console.log("successfully added");
      this.loadData();
     }); 
  }

  onBtnClick(value:any){
    console.log("view details clicked", value)
    const id = value.id;
    this.router.navigate(['employees',id]);
  }
}
