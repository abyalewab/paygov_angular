import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { SharedService } from '../shared.service';

@Component({
  selector: 'jhi-pay-gov',
  templateUrl: './pay-gov.component.html',
  styleUrls: ['./pay-gov.component.scss'],
})
export class PayGovComponent implements OnInit {
  form: FormGroup;

  constructor(private router: Router, private route: ActivatedRoute, private sharedService: SharedService, protected fb: FormBuilder) {
    this.form = new FormGroup({
      cik: new FormControl('', Validators.compose([Validators.required, Validators.pattern('^[0-9]+[@#$%^&*()!]')])),
      paymentAmount: new FormControl('', Validators.required),
      ccc: new FormControl('', Validators.compose([Validators.required, Validators.min(100000)])),
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.compose([Validators.required, Validators.pattern('^[0-9]{10}$')])),
    });
  }

  ngOnInit(): void {
    const formValues = sessionStorage.getItem('form');
    if (formValues) {
      this.applyFormValues(this.form, JSON.parse(formValues));
    }

    this.storeData();

    this.form.valueChanges.subscribe((form: any) => {
      sessionStorage.setItem('form', JSON.stringify(form));
    });
  }

  storeData(): void {
    const data: any = this.form.value;
    this.sharedService.setData(data);
  }

  applyFormValues(group: any, formValues: any): any {
    Object.keys(formValues).forEach((key: any) => {
      const formControl = <FormControl>group.controls[key];

      if (formControl instanceof FormGroup) {
        this.applyFormValues(formControl, formValues[key]);
      } else {
        formControl.setValue(formValues[key]);
      }
    });
  }
}
