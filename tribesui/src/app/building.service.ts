import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BuildingService {

  private buildingServiceURL = 'http://localhost:8080/' + 'buildings/';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.buildingServiceURL);
  }

  levelUpBuilding(id: string): Observable<Object>{
    console.log(this.buildingServiceURL + 'level-up/' + id);
    return this.http.put<Object>(this.buildingServiceURL + 'level-up/' + id, id);
  }

  remove(href: string){
    return this.http.delete(href);
  }

}
