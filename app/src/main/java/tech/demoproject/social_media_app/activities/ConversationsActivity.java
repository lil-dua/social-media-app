package tech.demoproject.social_media_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import tech.demoproject.social_media_app.R;
import tech.demoproject.social_media_app.databinding.ActivityConversationsBinding;

public class ConversationsActivity extends AppCompatActivity {

    private ActivityConversationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConversationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setListeners
        setListeners();
    }

    private void setListeners() {
        binding.imageBack.setOnClickListener(v -> onBackPressed());
    }


}