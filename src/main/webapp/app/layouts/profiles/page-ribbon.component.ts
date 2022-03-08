import { Component } from '@angular/core';
import { Observable } from 'rxjs';

import { ProfileService } from './profile.service';

@Component({
  selector: 'jhi-page-ribbon',
  template: `
    <div class="ribbon" *ngIf="ribbonEnv$ | async as ribbonEnv">
      <a href="">{{ ribbonEnv }}</a>
    </div>
  `,
  styleUrls: ['./page-ribbon.component.scss'],
})
export class PageRibbonComponent {
  ribbonEnv$?: Observable<string | undefined>;

  constructor(private profileService: ProfileService) {}
}
