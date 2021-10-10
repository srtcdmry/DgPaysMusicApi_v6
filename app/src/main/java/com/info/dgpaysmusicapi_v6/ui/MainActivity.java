package com.info.dgpaysmusicapi_v6.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.info.dgpaysmusicapi_v6.R;
import com.info.dgpaysmusicapi_v6.constants.AppConstants;
import com.info.dgpaysmusicapi_v6.databinding.ActivityMainBinding;
import com.info.dgpaysmusicapi_v6.view.AlbumActivity;
import com.info.dgpaysmusicapi_v6.view.ArticleActivity;
import com.info.dgpaysmusicapi_v6.view.PlaylistActivity;
import com.info.dgpaysmusicapi_v6.view.TrackActivity;

import dagger.hilt.android.AndroidEntryPoint;
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBind ;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = DataBindingUtil.setContentView(this, R.layout.activity_main); // data binding yoluyla bağlandı

        mainBind.tracksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TrackActivity.class);
                AppConstants.search = mainBind.editText.getText().toString();
                startActivity(intent);
            }
        });

        mainBind.artistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBind.editText.getText().toString().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
                    AppConstants.search = mainBind.editText.getText().toString();
                    startActivity(intent);
                }
            }
        });

        mainBind.playlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBind.editText.getText().toString().length() > 0) {

                    Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                    AppConstants.search = mainBind.editText.getText().toString();
                    startActivity(intent);
                }
            }
        });

        mainBind.albumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBind.editText.getText().toString().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                   AppConstants.search = mainBind.editText.getText().toString();
                    startActivity(intent);
                }
            }
        });

    }

}

