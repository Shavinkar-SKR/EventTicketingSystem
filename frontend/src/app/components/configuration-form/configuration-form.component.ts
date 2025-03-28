import { Component, OnInit } from '@angular/core';
import { ConfigurationService } from '../../services/configuration.service';
import { NgForm, FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
@Component({
  selector: 'app-configuration-form',
  standalone: true,
  imports: [FormsModule, NgIf],
  styleUrls: ['./configuration-form.component.css'],
  template: `
    <form (ngSubmit)="onSubmit(configForm)" #configForm="ngForm" novalidate>
      <div class="form-group">
        <label for="totalTickets">Total Tickets:</label>
        <input
          id="totalTickets"
          name="totalTickets"
          [(ngModel)]="config.totalTickets"
          required
          #totalTickets="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            totalTickets.invalid && (totalTickets.dirty || totalTickets.touched)
          "
          class="message"
        >
          <small *ngIf="totalTickets.errors?.['required']"
            >Total Tickets is required.</small
          >
          <small *ngIf="totalTickets.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="form-group">
        <label for="ticketsReleaseRate">Tickets Release Rate:</label>
        <input
          id="ticketsReleaseRate"
          name="ticketsReleaseRate"
          [(ngModel)]="config.ticketsReleaseRate"
          required
          #ticketsReleaseRate="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            ticketsReleaseRate.invalid &&
            (ticketsReleaseRate.dirty || ticketsReleaseRate.touched)
          "
          class="message"
        >
          <small *ngIf="ticketsReleaseRate.errors?.['required']"
            >Tickets Release Rate is required.</small
          >
          <small *ngIf="ticketsReleaseRate.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="form-group">
        <label for="customerRetrievalRate">Customer Retrieval Rate:</label>
        <input
          id="customerRetrievalRate"
          name="customerRetrievalRate"
          [(ngModel)]="config.customerRetrievalRate"
          required
          #customerRetrievalRate="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            customerRetrievalRate.invalid &&
            (customerRetrievalRate.dirty || customerRetrievalRate.touched)
          "
          class="message"
        >
          <small *ngIf="customerRetrievalRate.errors?.['required']"
            >Total Tickets is required.</small
          >
          <small *ngIf="customerRetrievalRate.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="form-group">
        <label for="maxTicketCapacity">Max Ticket Capacity:</label>
        <input
          id="maxTicketCapacity"
          name="maxTicketCapacity"
          [(ngModel)]="config.maxTicketCapacity"
          required
          #maxTicketCapacity="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            maxTicketCapacity.invalid &&
            (maxTicketCapacity.dirty || maxTicketCapacity.touched)
          "
          class="message"
        >
          <small *ngIf="maxTicketCapacity.errors?.['required']"
            >Maximum Ticket Capacity is required.</small
          >
          <small *ngIf="maxTicketCapacity.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="form-group">
        <label for="numberOfVendors">Number of Vendors:</label>
        <input
          id="numberOfVendors"
          name="numberOfVendors"
          [(ngModel)]="config.numberOfVendors"
          required
          #numberOfVendors="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            numberOfVendors.invalid &&
            (numberOfVendors.dirty || numberOfVendors.touched)
          "
          class="message"
        >
          <small *ngIf="numberOfVendors.errors?.['required']"
            >Number of Vendors is required.</small
          >
          <small *ngIf="numberOfVendors.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="form-group">
        <label for="numberOfCustomers">Number of Customers:</label>
        <input
          id="numberOfCustomers"
          name="numberOfCustomers"
          [(ngModel)]="config.numberOfCustomers"
          required
          #numberOfCustomers="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            numberOfCustomers.invalid &&
            (numberOfCustomers.dirty || numberOfCustomers.touched)
          "
          class="message"
        >
          <small *ngIf="numberOfCustomers.errors?.['required']"
            >Number of Customers is required.</small
          >
          <small *ngIf="numberOfCustomers.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="form-group">
        <label for="maximumTicketsCanBePurchased"
          >Maximum tickets per customer:</label
        >
        <input
          id="maximumTicketsCanBePurchased"
          name="maximumTicketsCanBePurchased"
          [(ngModel)]="config.maximumTicketsCanBePurchased"
          required
          #maximumTicketsCanBePurchased="ngModel"
          pattern="^[0-9]+$"
          class="form-input"
        />
        <div
          *ngIf="
            maximumTicketsCanBePurchased.invalid &&
            (maximumTicketsCanBePurchased.dirty ||
              maximumTicketsCanBePurchased.touched)
          "
          class="message"
        >
          <small *ngIf="maximumTicketsCanBePurchased.errors?.['required']"
            >Maximum Ticket to be Purchased is required.</small
          >
          <small *ngIf="maximumTicketsCanBePurchased.errors?.['pattern']"
            >Enter a valid number.</small
          >
        </div>
      </div>

      <div class="button-group">
        <button
          type="submit"
          [disabled]="configForm.invalid"
          class="btn btn-primary"
        >
          Start Simulation
        </button>
        <button
          type="button"
          (click)="stopSimulation()"
          class="btn btn-secondary"
        >
          Stop Simulation
        </button>
      </div>
    </form>
  `,
  styles: [],
})
export class ConfigurationFormComponent {
  config = {
    totalTickets: null,
    ticketsReleaseRate: null,
    customerRetrievalRate: null,
    maxTicketCapacity: null,
    numberOfVendors: null,
    numberOfCustomers: null,
    maximumTicketsCanBePurchased: null,
  };

  responseMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private configService: ConfigurationService) {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.responseMessage = null;
      this.errorMessage = null;

      this.configService.startSimulation(this.config).subscribe({
        next: (response) => {
          console.log('Response from startSimulation:', response);
          this.responseMessage = response;
        },
        error: (err) => {
          console.error('Error from startSimulation:', err);
          this.errorMessage = 'Failed to start the simulation.';
        },
      });
    } else {
      console.warn('Form is invalid');
    }
  }

  stopSimulation() {
    this.responseMessage = null;
    this.errorMessage = null;

    this.configService.stopSimulation().subscribe({
      next: (response) => {
        console.log('Response from stopSimulation:', response);
        this.responseMessage = response;
      },
      error: (err) => {
        console.error('Error from stopSimulation:', err);
        this.errorMessage = 'Failed to stop the simulation.';
      },
    });
  }
}
