import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HighlightcomponentComponent } from './components/highlightcomponent/highlightcomponent.component';
import { ProfilecomponentsComponent } from './components/profilecomponents/profilecomponents.component';
import { RadiosComponent } from './components/radios/radios.component';
import { FormsModule } from '@angular/forms';
import { PeopleComponent } from './components/people/people.component';
import { FirstcapPipe } from './pipes/firstcap.pipe';
import { FakeusersComponent } from './components/fakeusers/fakeusers.component';
import { NavComponent } from './components/nav/nav.component';

@NgModule({
  declarations: [
    AppComponent,
    HighlightcomponentComponent,
    ProfilecomponentsComponent,
    RadiosComponent,
    PeopleComponent,
    FirstcapPipe,
    FakeusersComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
