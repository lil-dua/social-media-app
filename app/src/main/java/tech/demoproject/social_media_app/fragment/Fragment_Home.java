package tech.demoproject.social_media_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import tech.demoproject.social_media_app.R;
import tech.demoproject.social_media_app.activities.ConversationsActivity;
import tech.demoproject.social_media_app.activities.SignInActivity;

/***
 * Created by HoangRyan aka LilDua on 11/6/2022.
 */
public class Fragment_Home extends Fragment {

    private View view;
    private AppCompatImageView imageViewSignOut,imageViewChat;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        //set event listeners
        setListeners();
        return view;

    }
    private void init(){
        imageViewSignOut = view.findViewById(R.id.imageSignOut);
        imageViewChat = view.findViewById(R.id.imageChat);
        recyclerView = view.findViewById(R.id.newsfeedRecyclerView);
    }
    private void setListeners() {
        imageViewSignOut.setOnClickListener(v -> startActivity(new Intent(getContext(), SignInActivity.class)));
        imageViewChat.setOnClickListener(v -> startActivity(new Intent(getContext(), ConversationsActivity.class)));
    }



}
