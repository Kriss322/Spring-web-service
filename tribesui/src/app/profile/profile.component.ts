import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  player: any = {};

  villageOfPlayer: any = {};
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private playerService: PlayerService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if(id){
        this.playerService.get(id).subscribe((player: any) =>{
          if(player){
      
            this.player = player;
            this.villageOfPlayer = player.villages;
            console.log(player);

            //this.village.href = village._links.self.href;
          } else {
            console.log(`Village with id '${id}' not found, returning to list`);
            this.goToList();
          }
        });
      }

    });
  }

  goToList(){
    this.router.navigate(['/ranks']);
  }

  ngOnDestroy(){
    this.sub.unsubscribe();
  }

  save(form: NgForm) {
    this.playerService.save(form).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

  remove(href) {
    this.playerService.remove(href).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }
}
