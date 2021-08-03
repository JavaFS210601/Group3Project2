import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  private links = new Array<{ text: string, path: string}>();
  private isLoggedIn = new Subject<boolean>();

  constructor() { 
    this.addItem({ text: 'Not Netflix', path: 'welcome'});
    this.addItem({ text: 'Signin', path: 'signin'});
    this.addItem({ text: 'Signup', path: 'signup'});
    this.isLoggedIn.next(false);
  }

  getLinks() {
    return this.links;
  }

  getLoginStatus() {
    return this.isLoggedIn;
  }

  updateLoginStatus(status: boolean) {
    this.isLoggedIn.next(status);

    if (!status) {
      this.clearAllItems();
      // this.addItem({ text: 'signin', path: 'signin' });
    }
  }

  updateNavAfterAuth(): void {
    this.removeItem({ text: 'Signin' });
    this.removeItem({ text: 'Signup' });
    this.removeItem({ text: 'Not Netflix' });

    this.addItem({ text: "Home", path: 'userhome' });
    this.addItem({ text: "Profile", path: 'userprofile' });

  }

  addItem({ text, path }: {text:any, path:any}) {
    this.links.push({ text: text, path: path });
  }

  removeItem({ text }: {text:any}) {
    this.links.forEach((link, index) => {
      if (link.text === text) {
        this.links.splice(index, 1);
      }
    });
  }

  clearAllItems() {
    this.links.length = 0;
  }
}

