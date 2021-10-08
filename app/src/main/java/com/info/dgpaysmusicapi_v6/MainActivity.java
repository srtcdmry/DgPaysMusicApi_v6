package com.info.dgpaysmusicapi_v6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        //  init();
        //getArticles();

//
//    private void getArticles() {
//
//        articleViewModel.getBashboardNewsResponseLiveData().observe(this, articleResponse -> {
//            if (articleResponse != null && articleResponse.getArticles() != null && !articleResponse.getArticles().isEmpty()) {
//
//                mainBind.progress_bar.setVisibility(View.GONE);
//                List<Article> articleList = articleResponse.getArticles();
//                articleArrayList.addAll(articleList);
//                adapter.notifyDataSetChanged();
//
//            }
//
//        });
//    }
//
//    private void init() {
//        progress_bar = findViewById(R.id.progress_bar);
//        recycler_View = findViewById(R.id.recycler_view);
//        layoutManager = new LinearLayoutManager(MainActivity.this);
//
//        recycler_View.setLayoutManager(layoutManager);
//        recycler_View.setHasFixedSize(true);
//        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
//        recycler_View.setAdapter(adapter);
//        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);

//        articleViewModel.getBashboardNewsResponseLiveData().observe(this,articleResponse ->{
//            if(articleResponse != null && articleResponse.getArticles()!=null && !articleResponse.getArticles().isEmpty()) {
//
//                progress_bar.setVisibility(View.GONE);
//                List<Article> articleList = articleResponse.getArticles();
//                articleArrayList.addAll(articleList);
//                adapter.notifyDataSetChanged();
//
//            }
//
//        } );



