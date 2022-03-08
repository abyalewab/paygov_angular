import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApplicationConfigService } from 'app/core/config/application-config.service';
import { IPay } from './pay.model';
import { IMockPg } from './mockpg.model';
import { IHostedPayment } from './hostedpayment.model';
export type EntityResponseType = HttpResponse<IPay>;
export type EntityArrayResponseType = HttpResponse<IPay[]>;

@Injectable({ providedIn: 'root' })
export class PayService {
  protected resourceUrl = this.applicationConfigService.getEndpointFor('api/pays');
  protected mockResourceUrl = this.applicationConfigService.getEndpointFor('api/mockpg');
  protected hostedPaymentUrl = this.applicationConfigService.getEndpointFor('api/paymentSB');
  protected payAmount = this.applicationConfigService.getEndpointFor('api/amountOfMoney');
  protected ppToken = this.applicationConfigService.getEndpointFor('api/paypal');
  protected EC = this.applicationConfigService.getEndpointFor('api/paypalGetEC');
  protected doEC = this.applicationConfigService.getEndpointFor('api/paypalDoEC');
  protected kafka = this.applicationConfigService.getEndpointFor('api/kafka');
  protected kafkadmin = this.applicationConfigService.getEndpointFor('api/kafkadmin');

  constructor(protected http: HttpClient, protected applicationConfigService: ApplicationConfigService) {}

  kafkaQueue(pay: IPay): Observable<EntityResponseType> {
    return this.http.post<IPay>(`${this.kafka}`, pay, { observe: 'response' });
  }

  kafkaAdmin(): Observable<IPay[]> {
    return this.http.get<IPay[]>(`${this.kafkadmin}`);
  }

  getPpToken(): any {
    return this.http.get<any>(`${this.ppToken}`, { observe: 'response' });
  }

  getEC(): any {
    return this.http.get<any>(`${this.EC}`, { observe: 'response' });
  }

  getDoEC(): any {
    return this.http.get<any>(`${this.doEC}`, { observe: 'response' });
  }

  getMockData(): any {
    return this.http.get<IMockPg>(`${this.mockResourceUrl}`, { observe: 'response' });
  }

  getHostedPayment(): any {
    return this.http.get<IHostedPayment>(`${this.hostedPaymentUrl}`, { observe: 'response' });
  }

  getPay(pay: IPay): Observable<EntityResponseType> {
    return this.http.post<IPay>(this.payAmount, pay, { observe: 'response' });
  }

  create(pay: IPay): Observable<EntityResponseType> {
    return this.http.post<IPay>(this.resourceUrl, pay, { observe: 'response' });
  }
}
