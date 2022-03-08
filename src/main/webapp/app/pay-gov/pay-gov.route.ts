import { Route } from '@angular/router';
import { PayGovComponent } from './pay-gov.component';

export const PayGov_ROUTE: Route = {
  path: '',
  component: PayGovComponent,
  data: {
    pageTitle: 'Welcome, PayGov !',
  },
};
