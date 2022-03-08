import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IPay } from '../pg-confirmation/pay.model';
import { PayService } from '../pg-confirmation/pay.service';
import { finalize } from 'rxjs/operators';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'jhi-kafkadmin',
  templateUrl: './kafkadmin.component.html',
  styleUrls: ['./kafkadmin.component.scss'],
})
export class KafkadminComponent implements OnInit {
  data: any;
  pay: IPay[] = [];
  isSaving = false;

  constructor(
    protected activatedRoute: ActivatedRoute,
    private router: Router,
    private route: ActivatedRoute,
    private modalService: NgbModal,
    protected payService: PayService
  ) {}

  ngOnInit(): void {
    this.kafkaAdmin();
  }

  kafkaAdmin(): any {
    setInterval(() => {
      this.payService.kafkaAdmin().subscribe((result: any) => {
        this.pay = result;
        console.log('Received Data ', this.pay);
      });
    }, 1000);
  }

  save(payment: IPay): void {
    const data = payment;
    console.log('payment data to be saved :', data);
    console.log('Payment approval status ', data.approvalStatus);

    if (data.approvalStatus === 'Decline') {
      data.approvalStatus = 'Approve';
      this.isSaving = true;
      this.subscribeToSaveResponse(this.payService.create(data));
    } else {
      this.isSaving = true;
      this.subscribeToSaveResponse(this.payService.create(data));
    }
  }

  decline(payment: IPay): void {
    const data = payment;

    console.log('payment data to be saved :', data);
    console.log('Payment approval status ', data.approvalStatus);

    if (data.approvalStatus === 'Approve') {
      data.approvalStatus = 'Decline';
      this.isSaving = true;
      this.subscribeToSaveResponse(this.payService.create(data));
    } else {
      this.isSaving = true;
      this.subscribeToSaveResponse(this.payService.create(data));
    }
  }

  openSuccess(): any {
    this.modalService.open(SuccessComponent);
  }

  openError(): any {
    this.modalService.open(ErrorComponent);
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPay>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.openSuccess();
    console.log('[]============== Payment saved successfully =====================[]');
  }

  protected onSaveError(): void {
    this.openError();
    console.log('[]============== Payment not saved  =====================[]');
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
      <h6>Payment saved successfully !</h6>
      <br />
    </div>

    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.dismiss('Cross click')">OK</button>
    </div>
  `,
  styleUrls: ['./kafkadmin.component.scss'],
})
export class SuccessComponent {
  data: any;

  constructor(private router: Router, private route: ActivatedRoute, private modalService: NgbModal, public activeModal: NgbActiveModal) {}
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
      <h6>Unable to save payment, please try again !</h6>
      <br />
    </div>

    <div class="modal-footer">
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.dismiss('Cross click')">OK</button>
    </div>
  `,
  styleUrls: ['./kafkadmin.component.scss'],
})
export class ErrorComponent {
  data: any;

  constructor(private router: Router, private route: ActivatedRoute, private modalService: NgbModal, public activeModal: NgbActiveModal) {}
}
