import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HighlightComponentComponent } from './components/highlight-component/highlight-component.component';
import { ProfilecomponentComponent } from './components/profilecomponent/profilecomponent.component';
import { SelectcomponentComponent } from './components/selectcomponent/selectcomponent.component';
import { TablecomponentComponent } from './components/tablecomponent/tablecomponent.component';
import { UserComponent } from './components/user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    HighlightComponentComponent,
    ProfilecomponentComponent,
    SelectcomponentComponent,
    TablecomponentComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
