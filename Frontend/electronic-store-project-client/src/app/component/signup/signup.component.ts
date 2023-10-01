import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../service/auth/auth.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  form: any = {
    
    username: null,
    password: null,
    cfpassword: null,
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }
  onSubmit(): void {
    const { username, password, cfpassword } = this.form;
    const status = "active";
    const role = "user";
    
    if (password===cfpassword) {
      this.authService.register(username, password, status, role).subscribe({
        next: data => {
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        },
        error: err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
      });
    } else this.errorMessage='ConfirmPassword is not true';
  }
}
