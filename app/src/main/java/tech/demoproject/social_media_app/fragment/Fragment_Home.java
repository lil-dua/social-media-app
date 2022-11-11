package tech.demoproject.social_media_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

import tech.demoproject.social_media_app.R;
import tech.demoproject.social_media_app.activities.ConversationsActivity;
import tech.demoproject.social_media_app.activities.MainActivity;
import tech.demoproject.social_media_app.activities.SignInActivity;
import tech.demoproject.social_media_app.utilities.Constants;
import tech.demoproject.social_media_app.utilities.PreferenceManager;

/***
 * Created by HoangRyan aka LilDua on 11/6/2022.
 */
public class Fragment_Home extends Fragment {

    private View view;
    private PreferenceManager preferenceManager;
    private AppCompatImageView imageViewSignOut,imageViewChat;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        //setup preference manager
        preferenceManager = new PreferenceManager(getContext());
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
        imageViewSignOut.setOnClickListener(v -> signOut());
        imageViewChat.setOnClickListener(v -> startActivity(new Intent(getContext(), ConversationsActivity.class)));
    }
    private void showToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
    //sign out
    private void signOut(){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USER).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        // When you sign out, the token will be remove from Firebase Database
        HashMap<String,Object> updates = new HashMap<>();
        updates.put(Constants.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getContext(), SignInActivity.class));
                })
                .addOnFailureListener(e -> showToast("Unable to sign out"));
    }



}
