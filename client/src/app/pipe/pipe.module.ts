import { NgModule } from '@angular/core';
import { SumPipe } from './pipe';

@NgModule({
    imports: [],
    declarations: [
        SumPipe
    ],
    exports: [
        SumPipe
    ]
})
export class PipeModule {
    static forRoot() {
        return {
            ngModule: PipeModule,
            providers: []
        };
    }
}
