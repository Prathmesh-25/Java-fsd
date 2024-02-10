import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PortalComponent } from './portal/portal.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';

const routes: Routes = [
  // {path:"",component:HomeComponent},
  {path:"", redirectTo: "/employees", pathMatch:'full'},
  {path:"home", component:HomeComponent},
  {path:"portal", component:PortalComponent},
  {path:"employees",component:EmployeesComponent},
  {path:"employees/:id",component:EmployeeDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

