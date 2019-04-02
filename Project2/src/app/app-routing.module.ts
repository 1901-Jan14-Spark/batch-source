import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { UpcomingComponent } from './components/upcoming/upcoming.component';
import { TrendingComponent } from './components/trending/trending.component';
import { SearchComponent } from './components/search/search.component';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';
import { AboutComponent } from './components/about/about.component';
import { StarComponent } from './components/star/star.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { RegistrationComponentComponent } from './components/registration-component/registration-component.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  {
    path:'profile',
    component: ProfileComponent,
  },
  {
    path:'register',
    component: RegistrationComponentComponent
  }, {
    path:'login',
    component: LoginComponentComponent
  }, {
    path: 'search',
    component: SearchComponent,
  }, {
    path: 'movies/nowplaying',
    component: HomeComponent
  }, {
    path: 'movies/upcoming',
    component: UpcomingComponent
  }, {
    path: 'movies/trending',
    component: TrendingComponent
  }, {
    path: 'movies/movie-detail',
    component: MovieDetailComponent
  }, {
    path: 'about',
    component: AboutComponent
  }, {
    path: 'star',
    component: StarComponent
  }, {
    path: '**',
    redirectTo: 'movies/nowplaying'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
