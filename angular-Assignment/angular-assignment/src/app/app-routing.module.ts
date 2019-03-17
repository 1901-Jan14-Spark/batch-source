import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HighlightComponent } from './Components/highlight/highlight.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { SelectComponent } from './Components/select/select.component';
import { UserComponent } from './Components/user/user.component';
import { TableComponent } from './Components/table/table.component';

const routes: Routes = [{
  path: 'Highlight',
  component: HighlightComponent
},{
  path: 'Profile',
  component: ProfileComponent
},{
  path: 'Select',
  component: SelectComponent
},{
  path: 'Table',
  component: TableComponent
},{
  path: 'User',
  component: UserComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
