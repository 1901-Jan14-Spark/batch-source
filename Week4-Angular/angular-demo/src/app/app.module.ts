import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { DatabindComponent } from './components/databind/databind.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { FavoriteComponent } from './components/favorite/favorite.component';
import { SDirectivesComponent } from './components/s-directives/s-directives.component';

@NgModule({
  declarations: [ // components and pipes
    AppComponent,
    FirstComponent,
    DatabindComponent,
    ClickerComponent,
    FavoriteComponent,
    SDirectivesComponent
  ],
  imports: [ // external modules
    BrowserModule,
    FormsModule
  ],
  providers: [], // services
  bootstrap: [AppComponent] // root component
})
export class AppModule { }
