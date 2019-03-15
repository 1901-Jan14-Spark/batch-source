import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { DatabindComponent } from './components/databind/databind.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { FavoriteComponent } from './components/favorite/favorite.component';
import { SDirectivesComponent } from './components/s-directives/s-directives.component';
import { ADirectivesComponent } from './components/a-directives/a-directives.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { FirstCapPipe } from './pipes/first-cap.pipe';
import { ConvertToSpacesPipe } from './pipes/convert-to-spaces.pipe';
import { HttpDemoComponent } from './components/http-demo/http-demo.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [ // components and pipes
    AppComponent,
    FirstComponent,
    DatabindComponent,
    ClickerComponent,
    FavoriteComponent,
    SDirectivesComponent,
    ADirectivesComponent,
    PipeDemoComponent,
    FirstCapPipe,
    ConvertToSpacesPipe,
    HttpDemoComponent
  ],
  imports: [ // external modules
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [], // services
  bootstrap: [AppComponent] // root component
})
export class AppModule { }
