import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { UntypedFormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  id:any;
  employeeData:any;
  employeeForm:any;

  constructor(private fb: UntypedFormBuilder,private api: ApiService, private route:ActivatedRoute,  private router:Router) { 
    this.employeeForm = this.fb.group({
      id: ['', [Validators.required]],
      first_name: ['', [Validators.required]],
      last_name: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    console.log("employee ID: ", this.id);
    this.loadData();
  }

  loadData(): void{
    this.api.getEmployeeById(this.id).subscribe((data)=>{
      console.log(data);
      this.employeeData=data;   
     });  
  }

  onEmployeeListHandler(){
    this.router.navigate(['employees']);
  }
  onDeleteHandler(emp:any){
    this.api.deleteEmployeeById(this.id).subscribe((data)=>{
      console.log(data);
      this.employeeData=data;
      this.router.navigate(['employees']);   
     });  
  }
  
  onSave(){
    var emp = new Employee();
    emp.Id=this.employeeForm.controls['id'].value;
    emp.first_name=this.employeeForm.controls['first_name'].value;
    emp.last_name=this.employeeForm.controls['last_name'].value;
    emp.email=this.employeeForm.controls['email'].value;
    this.api.updateEmployee(emp).subscribe((data)=>{
      console.log(data);
      console.log("successfully Updated");
      this.loadData();
     });  
  }

  onEmpBtnClick(emp:any){
    console.log("edit form", emp)
    this.employeeForm.patchValue(emp);
   }
}
