package com.info.dgpaysmusicapi_v6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.info.dgpaysmusicapi_v6.constants.AppConstants;
import com.info.dgpaysmusicapi_v6.databinding.ActivityAlbumBinding;
import com.info.dgpaysmusicapi_v6.databinding.ActivityPlayListArtistBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PlayListArtistActivity extends AppCompatActivity {

    public static String search;
    public ActivityPlayListArtistBinding artistBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        artistBinding = ActivityPlayListArtistBinding.inflate(getLayoutInflater());
        View view = artistBinding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        Glide.with(this)
                .load(intent.getStringExtra("picture"))
                .into(artistBinding.main8Picture);
       // Toast.makeText(this, intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
        artistBinding.artistName.setText(intent.getStringExtra("name"));
        artistBinding.main8Tracks.setText(intent.getStringExtra("link"));

        artistBinding.buttonTracklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PlayListArtistActivity.this,TrackActivity.class);
                //AppConstants.search = intent.getStringExtra("name");
                AppConstants.search = artistBinding.artistName.getText().toString();
                startActivity(intent1);
            }
        });

    }
}