import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FirstComponent } from './components/first/first.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { DatabindComponent } from './components/databind/databind.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { HttpDemoComponent } from './components/http-demo/http-demo.component';

const routes: Routes = [
{
    path: 'first',
    component: FirstComponent
},{
    path: 'clicker',
    component: ClickerComponent
}, {
    path: 'databind',
    component: DatabindComponent
}, {
    path: 'pipe',
    component: PipeDemoComponent
}, {
    path: 'posts',
    component: HttpDemoComponent
}, {
    path: '**',
    pathMatch: 'full',
    redirectTo: ''
}]

@NgModule({
    imports : [RouterModule.forRoot(routes)],
    exports : [RouterModule] 
})
export class AppRoutingModule{}
