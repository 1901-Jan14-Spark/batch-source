import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToSpaces'
})
export class ConvertToSpacesPipe implements PipeTransform {

  transform(value: string, char: string): string {
    for(let i = 0; i<value.length; i++){
      if(value.charAt(i)==char){
        value = value.substring(0,i)+' '+value.substring(i+1);
      }
    }
    return value;
  }

}
