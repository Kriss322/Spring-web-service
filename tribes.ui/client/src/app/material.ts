// all imports form angular material go in this file
import {NgModule} from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatCardModule} from '@angular/material/card';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDialogModule} from '@angular/material/dialog';
import {MatSelectModule} from '@angular/material/select';
import {MatStepperModule} from '@angular/material/stepper';
import {MatChipsModule} from '@angular/material/chips';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner'



@NgModule({
  imports: [ MatProgressBarModule, MatProgressSpinnerModule,
    MatSnackBarModule, MatAutocompleteModule, MatChipsModule, MatStepperModule, MatSelectModule, MatDialogModule, MatGridListModule,
    MatInputModule, MatFormFieldModule,
    MatButtonToggleModule, MatButtonModule, MatCheckboxModule,
    MatToolbarModule, MatIconModule, MatSidenavModule,
    MatListModule, MatTabsModule, MatExpansionModule,
    MatCardModule, MatSlideToggleModule],

  exports: [ MatProgressBarModule, MatProgressSpinnerModule,
    MatSnackBarModule, MatAutocompleteModule, MatChipsModule, MatStepperModule, MatSelectModule, MatDialogModule,
    MatGridListModule, MatInputModule,
    MatFormFieldModule, MatButtonToggleModule, MatButtonModule,
    MatCheckboxModule, MatToolbarModule,
    MatIconModule, MatSidenavModule, MatListModule, MatTabsModule, MatExpansionModule, MatCardModule,
    MatSlideToggleModule],
})
export class MaterialModule { }
