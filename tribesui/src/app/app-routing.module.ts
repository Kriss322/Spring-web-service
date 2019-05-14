import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OverviewComponent } from './overview/overview.component';
import { MapComponent } from './map/map.component';
import { VillageComponent } from './village/village.component';
import { TribeComponent } from './tribe/tribe.component';
import { ProfileComponent } from './profile/profile.component';
import { MessagesComponent } from './messages/messages.component';
import { RanksComponent } from './ranks/ranks.component';
import {RegisterPlayerComponent } from './register-player/register-player.component'

const routes: Routes = [
  { path: '', redirectTo: '/overview', pathMatch: 'full'},
  { path: 'overview', component: OverviewComponent },
  { path: 'map', component: MapComponent },
  { path: 'village/:id', component: VillageComponent },
  { path: 'tribe', component: TribeComponent },
  { path: 'profile/:id', component: ProfileComponent },
  { path: 'messages', component: MessagesComponent },
  { path: 'ranks', component: RanksComponent },
  { path: 'register-player', component: RegisterPlayerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
