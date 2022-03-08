import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { PayService } from './pay.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'jhi-pg-confirmation',
  templateUrl: './pg-confirmation.component.html',
  styleUrls: ['./pg-confirmation.component.scss'],
})
export class PgConfirmationComponent implements OnInit {
  isSaving = false;
  data: any;
  pgData: any;
  mockData: any;
  loading = true;
  timeLeft: any = 10;
  interval: any;
  redirectUrl: any;
  form: any;
  formValues: any;

  String1: any = 'https://payment.';
  String2: any;
  String3: any;
  token: any;
  ppUrl: any;
  ppToken: any;
  fullPaypalUrl: any;

  doc: any;
  parser: any;

  constructor(
    protected payService: PayService,
    private router: Router,
    private route: ActivatedRoute,
    private sharedService: SharedService,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.formValues = sessionStorage.getItem('form');

    this.data = JSON.parse(this.formValues);

    this.payService.getPay(this.data).subscribe((msg: any) => {
      const dt = msg;
      console.log('Sending payment amount to paypal : ', dt);
    });

    this.startTimer();

    this.storedData(this.data);
  }

  startTimer(): any {
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.loading = false;
        document.getElementById('redirect')!.style.display = 'none';
        this.pauseTimer();

        this.payService.getPpToken().subscribe((ppToken: any) => {
          this.token = JSON.stringify(ppToken);
          this.ppUrl = JSON.parse(this.token);
          window.location.href = this.ppUrl.body;
        });
      }
    }, 1000);
  }

  pauseTimer(): any {
    clearInterval(this.interval);
  }

  previousState(): void {
    window.history.back();
  }

  getFormData(): void {
    this.data = this.sharedService.getData();
  }

  storedData(data: any): void {
    const jsonData = JSON.stringify(data);
    localStorage.setItem('formData', jsonData);
  }
}
