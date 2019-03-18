import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { HighlightcomponentComponent } from './components/highlightcomponent/highlightcomponent.component';
import { ProfilecomponentsComponent } from './components/profilecomponents/profilecomponents.component';
import { RadiosComponent } from './components/radios/radios.component';
import { PeopleComponent } from './components/people/people.component';
import { FakeusersComponent } from './components/fakeusers/fakeusers.component';

const routes: Routes = [
  {
      path: 'highlight',
      component: HighlightcomponentComponent
  },{
      path: 'profile',
      component: ProfilecomponentsComponent
  }, {
      path: 'select',
      component: RadiosComponent
  }, {
      path: 'table',
      component: PeopleComponent
  }, {
      path: 'user',
      component: FakeusersComponent
  }]

  @NgModule({
    imports : [RouterModule.forRoot(routes)],
    exports : [RouterModule] 
})
export class AppRoutingModule { }