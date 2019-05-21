import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VillageService {

  unit: UnitSet = {name: "", numberOfSoldiers: 0};

  private villageServiceURL = 'http://localhost:8080/' + 'villages';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.villageServiceURL);
  }

  get(id: string) {
    return this.http.get(this.villageServiceURL + '/' + id);
  }

  getBuildingsOfVillage(id: string){
    return this.http.get(this.villageServiceURL + '/' + id + '/buildings');
  }

  save(village: any): Observable<any> {
    let result: Observable<Object>;
    if(village['href']) {
      result = this.http.put(village.href, village);
    } else {
      result = this.http.post(this.villageServiceURL, village);
    }
    return result;
  }

  remove(href: string){
    return this.http.delete(href);
  }

  trainUnits(id: string, name: string, amount: number){
    this.unit.numberOfSoldiers = amount;
    this.unit.name = name;
    console.log(id + " "+ this.unit.numberOfSoldiers);
    return this.http.patch(this.villageServiceURL + '/' + id, this.unit);
  }
}
