import { Component, OnInit, ViewChild, ViewContainerRef, ComponentRef, Compiler, Injector, NgModuleRef, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ReportService } from '../service/report.service';
import { PipeModule } from '../pipe/pipe.module';
import * as jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-root',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
  @ViewChild('reportContent', { read: ViewContainerRef, static: true }) vc: ViewContainerRef;

  private cmpRef: ComponentRef<any>;

  month:number;
  reportId: number;

  constructor(private compiler: Compiler,
    private injector: Injector,
    private moduleRef: NgModuleRef<any>,
    private reportService: ReportService
  ) { }

  ngOnInit(): void {

  }

  ngAfterViewInit() {
    this.callApi();
  }

  callApi() {
    if (this.cmpRef) {
      this.cmpRef.destroy();
    }
    this.reportService.getdata({
      reportId: this.reportId,
      month: this.month,
    }).then(body => {
      this.createComponentFromRaw(body.reportContent, body);
      console.log(body);
    })
  }

  private createComponentFromRaw(template: string, body) {
    const styles = [];
    function TmpCmpConstructor() {
      this.data = [];
      for (let i = 0; i < body.reportPramValue.dataContent.length; i++) {
        const element = body.reportPramValue.dataContent[i];
        this.data.push(element.properties);
      }
      this.configData = body.reportPramValue;
    }
    const tmpCmp = Component({ template, styles })(new TmpCmpConstructor().constructor);

    // Now, also create a dynamic module.
    const tmpModule = NgModule({
      imports: [CommonModule, PipeModule],
      declarations: [tmpCmp],
      // providers: [] - e.g. if your dynamic component needs any service, provide it here.
    })(class { });

    // Now compile this module and component, and inject it into that #vc in your current component template.
    this.compiler.compileModuleAndAllComponentsAsync(tmpModule)
      .then((factories) => {
        const f = factories.componentFactories[0];
        this.cmpRef = f.create(this.injector, [], null, this.moduleRef);
        this.cmpRef.instance.name = 'my-dynamic-component';
        this.vc.insert(this.cmpRef.hostView);
      });
  }

  // Cleanup properly. You can add more cleanup-related stuff here.
  ngOnDestroy() {
    if (this.cmpRef) {
      this.cmpRef.destroy();
    }
  }

  htmltoPDF() {
    // parentdiv is the html element which has to be converted to PDF
    html2canvas(document.querySelector("#report")).then(canvas => {

      var pdf = new jsPDF('p', 'pt', [canvas.width, canvas.height]);

      var imgData = canvas.toDataURL("image/jpeg", 10.0);
      //pdf.addImage(imgData, 0, 0, canvas.width, canvas.height);
      pdf.html(canvas);
      pdf.save('converteddoc.pdf');

    });

  }
}
