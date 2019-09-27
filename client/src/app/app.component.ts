import { Component, OnInit, ViewChild, ViewContainerRef, ComponentRef, Compiler, Injector, NgModuleRef, NgModule } from '@angular/core';
import { ReportService } from './service/report.service';
import { CommonModule } from '@angular/common';
import { PipeModule } from './pipe/pipe.module';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DialogComponent } from './dialog/dialog.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  @ViewChild('reportContent', { read: ViewContainerRef, static: true }) rp: ViewContainerRef;

  month:number;
  reportId: number;

  constructor(
    private modalService: NgbModal, 
  ) { }

  ngOnInit(): void {

  }

  ngAfterViewInit() {
  }

  openDetail(): NgbModalRef {
    const modalRef = this.modalService.open(DialogComponent, { size: 'lg', backdrop: 'static'});
    modalRef.componentInstance.reportId = this.reportId;
    modalRef.componentInstance.month = this.month;
    modalRef.result.then(
      result => {
      },
      reason => {
      }
    );
    return modalRef;
  }
}
