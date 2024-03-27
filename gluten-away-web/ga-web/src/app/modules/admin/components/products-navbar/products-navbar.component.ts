import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products-navbar',
  templateUrl: './products-navbar.component.html',
  styleUrls: ['./products-navbar.component.css']
})
export class ProductsNavbarComponent implements OnInit {
  expandedSidebar: boolean = true;

  ngOnInit(): void {
    this.toggleSidebar();
  }
  toggleSidebar(){
    this.expandedSidebar = !this.expandedSidebar;
    const mainContent = document.querySelector(".main");
    if (mainContent) {
      mainContent.classList.toggle("collapsed", !this.expandedSidebar);
  }
  }
  

}
