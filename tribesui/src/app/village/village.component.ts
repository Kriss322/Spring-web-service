import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { VillageService } from '../village.service';
import { BuildingService } from '../building.service';
@Component({
  selector: 'app-village',
  templateUrl: './village.component.html',
  styleUrls: ['./village.component.scss']
})
export class VillageComponent implements OnInit {

  village: any = {};

  villageBuildings: any[] = [];

  warehouse: any = {};

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private villageService: VillageService,
              private buildingService: BuildingService) { }

  ngOnInit() {
    
    setInterval(() => {
      this.update();
    },500)

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
      
        this.villageService.getBuildingsOfVillage(id).subscribe((buildings: any[]) =>{
          if(buildings){
            this.villageBuildings = buildings;
            //this.warehouse = buildings[12];
            //console.log(this.warehouse);
          } else {
            console.log(`Village with id '${id}' not found, returning to list`);
            this.goToList();
          }
        });
      
      }
    });
  }

  levelUpBuilding(id: string){
    console.log('from lvlup');
    this.buildingService.levelUpBuilding(id).subscribe(result => {
      console.log(result);
      this.update();
    }, error => console.error(error));
  }

  ngOnDestroy(){
    this.sub.unsubscribe();
  }

  goToList(){
    this.router.navigate(['/overview']);
  }

  save(form: NgForm) {
    this.villageService.save(form).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

  remove(href) {
    this.villageService.remove(href).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }
}
