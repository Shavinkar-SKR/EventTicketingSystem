import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConfigurationService {
  private apiUrl = 'http://localhost:8080/api/configuration'; // Spring Boot API base URL

  constructor(private http: HttpClient) {}

  saveConfiguration(config: any): Observable<string> {
    console.log('Sending saveConfiguration request:', config);
    return this.http.post<string>(`${this.apiUrl}/save`, config);
  }

  getConfiguration(): Observable<any> {
    console.log('Sending getConfiguration request');
    return this.http.get<any>(`${this.apiUrl}/get`);
  }

  startSimulation(config: any): Observable<string> {
    console.log('Sending startSimulation request:', config);
    return this.http.post<string>(`${this.apiUrl}/simulation/start`, config);
  }

  stopSimulation(): Observable<string> {
    console.log('Sending stopSimulation request');
    return this.http.post<string>(`${this.apiUrl}/simulation/stop`, {});
  }
}
