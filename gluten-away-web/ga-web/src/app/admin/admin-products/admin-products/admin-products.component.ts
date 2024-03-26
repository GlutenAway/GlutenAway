import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {
  expandedSidebar: boolean = true;

  ngOnInit(): void {
    const hamBurger = document.querySelector(".toggle-btn");
    const mainContent = document.querySelector(".main");
    mainContent?.classList.add("expand-content");
    hamBurger!.addEventListener("click", () => {
      document.querySelector("#sidebar")!.classList.toggle("expand");
      this.expandedSidebar = !this.expandedSidebar;

      if (mainContent) {
        if (this.expandedSidebar) {
          mainContent.classList.add("expand-content");
        } else {
          mainContent.classList.remove("expand-content");
        }
      }
    });
  }

}
