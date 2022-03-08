import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';
import { SharedService } from '../shared.service';
import { PayService } from '../pg-confirmation/pay.service';
import { IPay } from '../pg-confirmation/pay.model';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'jhi-pg-modal',
  templateUrl: './payment-save.component.html',
  styleUrls: ['./payment-save.component.scss'],
})
export class PaymentSaveComponent implements OnInit {
  isSaving = false;
  lsData: any;
  formData: any;
  data: any;
  doEC: any;
  dataDoEC: any;
  disabled: any;
  constructor(
    protected activatedRoute: ActivatedRoute,
    private router: Router,
    private route: ActivatedRoute,
    private modalService: NgbModal,
    protected payService: PayService,
    private sharedService: SharedService
  ) {
    this.lsData = localStorage.getItem('formData');
    this.formData = JSON.parse(JSON.stringify(this.lsData));
    this.data = JSON.parse(this.formData);
  }

  ngOnInit(): void {
    this.payService.getDoEC().subscribe((msg: any) => {
      this.dataDoEC = JSON.stringify(msg);
      this.doEC = JSON.parse(this.dataDoEC);
      console.log(this.doEC.body);
    });

    this.submitPoll();
  }

  save(): void {
    this.isSaving = true;
    const pay = this.data;
    this.subscribeToSaveResponse(this.payService.kafkaQueue(pay));
  }

  openSuccess(): any {
    this.modalService.open(SuccessComponent);
  }

  openError(): any {
    this.modalService.open(ErrorComponent);
  }

  destroyFormValues(): any {
    sessionStorage.removeItem('form');
  }

  previousState(): void {
    window.history.back();
  }

  submitPoll(): void {
    (<HTMLInputElement>document.getElementById('completebutton')).disabled = true;

    setTimeout(function () {
      (<HTMLInputElement>document.getElementById('completebutton')).disabled = false;
    }, 8000);
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPay>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.destroyFormValues();
    this.router.navigate(['/']);
    this.openSuccess();
  }

  protected onSaveError(): void {
    this.router.navigate(['/payment-page']);
    this.openError();
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }
}

@Component({
  selector: 'jhi-my-modal',
  template: `
    <div class="modal-header" id="successModal">
      <h4 class="modal-title"><strong>Confirmation Message</strong></h4>
      <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

    <div class="modal-body">
      <br />
      <h6>First step of payment process completed successfully !</h6>
      <h6>Final payment result will be sent to your email address !</h6>
      <br />
    </div>

    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.dismiss('Cross click')" (click)="finish()">OK</button>
    </div>
  `,
  styleUrls: ['./payment-save.component.scss'],
})
export class SuccessComponent {
  data: any;

  constructor(private router: Router, private route: ActivatedRoute, private modalService: NgbModal, public activeModal: NgbActiveModal) {}

  finish(): void {
    parent.window.close();
    this.router.navigate(['/']);
  }
}

@Component({
  selector: 'jhi-my-modal',
  template: `
    <div class="modal-header" id="errorModal">
      <h4 class="modal-title"><strong>Confirmation Message</strong></h4>
      <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>

    <div class="modal-body">
      <br />
      <h6>Unable to finish payment process, please try again !</h6>
      <br />
    </div>

    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.dismiss('Cross click')" (click)="finish()">OK</button>
    </div>
  `,
  styleUrls: ['./payment-save.component.scss'],
})
export class ErrorComponent {
  data: any;

  constructor(private router: Router, private route: ActivatedRoute, private modalService: NgbModal, public activeModal: NgbActiveModal) {}

  finish(): void {
    this.router.navigate(['/']);
  }
}
