import { Component } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { CommonModule } from '@angular/common'

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [MatCardModule, CommonModule],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {
  projectsData = [
    {
      name: 'Project 1',
      technologies: 'React, Node.js',
      image: '../../assets/images/React.jpg',
      description: 'Description for Project 1.',
    },
    {
      name: 'Project 2',
      technologies: 'Angular, TypeScript',
      image: '../../assets/images/angular-logo.jpg',
      description: 'Description for Project 2.',
    },
  ]
}
