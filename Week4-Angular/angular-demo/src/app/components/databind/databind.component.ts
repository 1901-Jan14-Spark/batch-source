import { Component } from '@angular/core';


@Component({
    selector: 'app-databind',
    templateUrl: './databind.component.html'
})
export class DatabindComponent {

    name: string = 'Ron';

    email: string = 'ron@gmail.com';

    person = {name: 'Jimmy', email: 'jimbo@gmail.com'}

}