import { Pipe, PipeTransform, Injector } from '@angular/core';

@Pipe({
    name: 'sumPipe'
})
export class SumPipe implements PipeTransform {
    transform(items: any[], attr: string): any {
        console.log(items);
        return items.reduce((a, b) => a + b[attr], 0);
    }
}
