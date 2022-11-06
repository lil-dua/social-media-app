package tech.demoproject.social_media_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import tech.demoproject.social_media_app.R;
import tech.demoproject.social_media_app.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //set binding
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set event listeners
        setListeners();
    }

    private void setListeners() {
        // switching to Sign In Activity
        binding.textSignIn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),SignInActivity.class));
        });
        // Access to Main Activity
        binding.buttonSignUp.setOnClickListener(v -> {
            signUp();

        });
        // Image Profile
    }

    private void signUp() {
        loading(true);
        startActivity(new Intent(getApplicationContext(),SignInActivity.class));
        Toast.makeText(getApplicationContext(), "Sign up successfully!", Toast.LENGTH_SHORT).show();
    }

    // loading for Sign Up
    private void loading(Boolean isLoading){
        if(isLoading){
            binding.buttonSignUp.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }else {
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignUp.setVisibility(View.VISIBLE);
        }
    }

}