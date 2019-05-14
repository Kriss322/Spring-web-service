import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import {PlayerService} from "../player.service";

@Component({
  selector: 'app-register-player',
  templateUrl: './register-player.component.html',
  styleUrls: ['./register-player.component.scss']
})
export class RegisterPlayerComponent implements OnInit {

  player: any = {};

  constructor(private route: ActivatedRoute,
    private router: Router,
    private playerService: PlayerService) { }

  ngOnInit() {
  }

  save(form: NgForm) {
    this.playerService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  gotoList() {
    this.router.navigate(['/ranks']);
  }
}
