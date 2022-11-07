package tech.demoproject.social_media_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;

import tech.demoproject.social_media_app.R;
import tech.demoproject.social_media_app.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {

    private ActivityEditProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        //set binding
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //set Listeners
        setListeners();
    }

    private void setListeners() {
        //back press
        binding.imageBack.setOnClickListener(v -> DialogCancel());
        //done
        binding.imageDone.setOnClickListener(v -> onBackPressed());
    }

    //Cancel dialog
    private void DialogCancel(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to stop change?");
        //Confirm:
        builder.setNegativeButton("Yes",(dialogInterface, i) -> onBackPressed());
        //Stay:
        builder.setPositiveButton("No",(dialogInterface, i) -> {
            //Stay
        });
        builder.show();
    }
}