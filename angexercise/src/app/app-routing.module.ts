import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HighlightComponentComponent} from './components/highlight-component/highlight-component.component';
import { ProfilecomponentComponent } from './components/profilecomponent/profilecomponent.component';
import { SelectcomponentComponent } from './components/selectcomponent/selectcomponent.component';
import { TablecomponentComponent } from './components/tablecomponent/tablecomponent.component';
import { UserComponent } from './components/user/user.component';

const routes: Routes = [
  {
  path: 'highlight',
  component: HighlightComponentComponent
},
  {
    path: 'profile',
    component: ProfilecomponentComponent
  },
  {
    path: 'select',
    component: SelectcomponentComponent
  },
  {
    path: 'table',
    component: TablecomponentComponent
  },
  {
    path: 'user',
    component: UserComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
