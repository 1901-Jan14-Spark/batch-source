
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HighlightComponent } from './highlight/highlight.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  { path: 'highlight', component: HighlightComponent },
  { path: 'profile', component: ProfileComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }