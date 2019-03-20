import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FillerTextComponent } from './filler-text/filler-text.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponent } from './select/select.component';
import { TableComponent } from './table/table.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {
    path: 'filler',
    component: FillerTextComponent
  },{
    path: 'profiles',
    component: ProfileComponent
  },{ 
    path: 'list',
    component: SelectComponent
  },{
    path: 'table',
    component: TableComponent
  },{
    path: 'users',
    component: UserComponent
  },{
    path: '**',
    pathMatch: 'full',
    redirectTo: ''
  }]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
