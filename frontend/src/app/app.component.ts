import { Component } from '@angular/core';
import { ConfigurationFormComponent } from './components/configuration-form/configuration-form.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ConfigurationFormComponent, FormsModule],
  template: `
    <h1>Ticketing System Simulation</h1>
    <app-configuration-form></app-configuration-form>
  `,
  styles: [],
})
export class AppComponent {}
