import { Component, OnInit } from '@angular/core';
import { Subscribable, Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { VillageService } from '../village.service';

@Component({
  selector: 'app-attack',
  templateUrl: './attack.component.html',
  styleUrls: ['./attack.component.scss']
})
export class AttackComponent implements OnInit {

  village: any = {};

  trainAmount: any ;

  villageUnits: any[] = [];

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private villageService: VillageService) { }

  ngOnInit() {

    //setInterval(() => {
      this.update();
    //},500)

  }

  onSubmit(event: any) {
    console.log(event.target.amount.value);

    this.trainAmount = event.target.amount.value;

    return event.target.amount.value;
 }

  update(){
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if(id){
        this.villageService.get(id).subscribe((village: any) =>{
          if(village){
            this.village = village;
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
    this.router.navigate(['/overview']);
  }

  trainUnits(id: string, name: string, amount: any){
    console.log(id + ", " + name + ", " + amount);

    this.villageService.trainUnits(id, name, amount).subscribe(result => {
      console.log(result);
      this.update();
    }, error => console.error(error));
  }

}
