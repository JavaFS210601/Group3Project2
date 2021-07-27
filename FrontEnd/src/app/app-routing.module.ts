import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserHomepageComponent } from './components/user-homepage/user-homepage.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [

  {path:'' , component:WelcomeComponent },
  {path:'welcome', component: WelcomeComponent },
  {path:'userhome', component: UserHomepageComponent },
  {path:'userprofile', component: UserProfileComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
