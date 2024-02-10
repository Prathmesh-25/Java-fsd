import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
// import { BrowserModule } from '@angular/platform-browser'
import { CommonModule } from '@angular/common'
@Component({
  selector: 'app-about',
  standalone: true,
  imports: [MatCardModule, CommonModule],
  templateUrl: './about.component.html',
  styleUrl: './about.component.css'
})
export class AboutComponent {
  educationData = [
    {
      degree: 'Bachelor of technology',
      institution: 'AKTU',
      branch: 'Electronics and Communication Engineering',
      year: 2022,
    }
  ]
}
