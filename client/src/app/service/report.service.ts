import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { createRequestOption } from './request-util';

@Injectable()
export class ReportService {

    private resourceUrl = "http://localhost:8080/api/getData";
    constructor(private http: HttpClient) { }

    query(req?: any): Observable<HttpResponse<any>> {
        const options = createRequestOption(req);
        return this.http
            .get<any>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: HttpResponse<any>) => res));
    }

    async getdata(req?: any): Promise<any> {
        try {
            const options = createRequestOption(req);
            let response = await this.http
                .get<any>(this.resourceUrl, { params: options, observe: 'response' })
                .toPromise();
            return response.body;
        } catch (error) {
            return null;
        }
    }
}