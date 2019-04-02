import { BrowserModule, DomSanitizer } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UpcomingComponent } from './components/upcoming/upcoming.component';
import { TrendingComponent } from './components/trending/trending.component';
import { SearchComponent } from './components/search/search.component';
import { MovieDetailComponent } from './components/movie-detail/movie-detail.component';
import { AboutComponent } from './components/about/about.component';
import { StarComponent } from './components/star/star.component';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { RegistrationComponentComponent } from './components/registration-component/registration-component.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MyMaterialModule } from './material.module';
import { ProfileComponent } from './components/profile/profile.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    UpcomingComponent,
    TrendingComponent,
    SearchComponent,
    MovieDetailComponent,
    AboutComponent,
    StarComponent,
    LoginComponentComponent,
    RegistrationComponentComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MyMaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
