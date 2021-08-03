import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { UserHomepageComponent } from './components/user-homepage/user-homepage.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [

  {path:'', component: WelcomeComponent },
  {
    path: '',
    redirectTo: '/welcome',
    pathMatch: 'full'
},
  {path:'welcome', component: WelcomeComponent },
  {path:'userhome', component: UserHomepageComponent },
  {path:'userprofile', component: UserProfileComponent },
  {path:'signin', component: SigninComponent },
  {path:'signup', component: SignupComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
