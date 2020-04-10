import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FetchAllEmployeesComponent } from './fetch-all-employees/fetch-all-employees.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { GetEmployeeComponent } from './get-employee/get-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';


const routes: Routes = [

  { path: 'createEmployee',component: CreateEmployeeComponent},
  { path: 'employeesList', component: FetchAllEmployeesComponent },
  { path:'getEmployee',component:GetEmployeeComponent},
  { path:'updateEmployee',component:UpdateEmployeeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
