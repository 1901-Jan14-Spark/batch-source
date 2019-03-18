import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HighlightComponent } from './components/highlight/highlight.component';
import { UserComponent } from './components/user/user.component';
import { SelectComponent } from './components/select/select.component';
import { TableComponent } from './components/table/table.component';
import { ProfilesComponent } from './components/profiles/profiles.component';


const routes: Routes = [{
  path: 'highlight',
  component: HighlightComponent
}, {
  path: 'user',
  component: UserComponent
}, {
  path: 'select',
  component: SelectComponent
}, {
  path: 'table',
  component: TableComponent
}, {
  path: 'profiles',
  component: ProfilesComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
