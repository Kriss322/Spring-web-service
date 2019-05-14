import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-ranks',
  templateUrl: './ranks.component.html',
  styleUrls: ['./ranks.component.scss']
})
export class RanksComponent implements OnInit {

  players: Array<any>;

  constructor(private playerServce: PlayerService) { }

  ngOnInit() {

    this.playerServce.getAll().subscribe(data => {
      this.players = data;
    })
  }
}
