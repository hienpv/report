import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReportService } from './service/report.service';
import { PipeModule } from './pipe/pipe.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { DialogComponent } from './dialog/dialog.component';
import { NgxPrintModule } from 'ngx-print';


@NgModule({
  declarations: [
    AppComponent,
    DialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    NgxPrintModule,
    PipeModule.forRoot()
  ],
  entryComponents: [
    DialogComponent,
  ],
  providers: [ReportService],
  bootstrap: [AppComponent]
})
export class AppModule { }
