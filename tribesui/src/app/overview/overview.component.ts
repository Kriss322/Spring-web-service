import { Component, OnInit } from '@angular/core';
import { VillageService } from '../village.service';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {

  villages: Array<any>;

  panelOpenState = false;
  
  constructor(private villageService: VillageService) { }

  ngOnInit() {

    this.villageService.getAll().subscribe(data => {
      this.villages = data;
    })
  }

}
