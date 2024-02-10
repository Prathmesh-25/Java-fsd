
import { Component } from '@angular/core';
// import { ProductsComponent } from './products/products.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';
}
export class ProductsComponent{
  pageTitle: string = "Product List Page";
  imageWidth:number = 80;
  imageMargin:number = 10;

  showImage:boolean = false;

  toggleImage() : void {
      this.showImage = !this.showImage;
      // (!false = true) // (!true == false)
console.log('Value of ShowImage inside function ::',                              this.showImage);   
  }

}