import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private playerServiceURL = 'http://localhost:8080/' + 'players';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.playerServiceURL);
  }

  remove(href: string){
    return this.http.delete(href);
  }

  get(id: string) {
    return this.http.get(this.playerServiceURL + '/' + id);
  }

  save(player: any): Observable<any> {
    let result: Observable<Object>;
    if(player['href']) {
      result = this.http.put(player.href, player);
    } else {
      result = this.http.post(this.playerServiceURL, player);
    }
    return result;
  }
}
