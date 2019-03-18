import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { HighlightComponent } from './highlight/highlight.component';
import { ProfileComponent } from './profile/profile.component';
import { SelectComponent } from './select/select.component';

@NgModule({
  declarations: [
    AppComponent,
    HighlightComponent,
    ProfileComponent,
    SelectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
