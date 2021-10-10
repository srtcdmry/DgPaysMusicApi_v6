package com.info.dgpaysmusicapi_v6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.info.dgpaysmusicapi_v6.adapter.AlbumAdapter;
import com.info.dgpaysmusicapi_v6.databinding.ActivityAlbumBinding;
import com.info.dgpaysmusicapi_v6.model.Album;
import com.info.dgpaysmusicapi_v6.viewModel.AlbumViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AlbumActivity extends AppCompatActivity implements AlbumAdapter.ItemListener4 {

    private static final String TAG = AlbumActivity.class.getSimpleName();
    private ArrayList<Album> albumArrayList = new ArrayList<>();
    AlbumViewModel albumViewModel;
    private AlbumAdapter adapter;
    public ActivityAlbumBinding albumBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumBinding = ActivityAlbumBinding.inflate(getLayoutInflater());
        View view = albumBinding.getRoot();
        setContentView(view);
        init();

    }

    private void init() {

        albumBinding.recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        albumBinding.recyclerView.setLayoutManager(mLayoutManager);
        adapter = new AlbumAdapter(AlbumActivity.this, albumArrayList);
        adapter.setItemListener(this);
        albumBinding.recyclerView.setAdapter(adapter);
        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        DividerItemDecoration id = new DividerItemDecoration(this, mLayoutManager.getOrientation());
        albumBinding.recyclerView.addItemDecoration(id);

        albumViewModel.getAlbumResponseLiveData().observe(this, albumResponse -> {
            if (albumResponse != null && albumResponse.getData() != null && !albumResponse.getData().isEmpty()) {

                albumBinding.progressBar.setVisibility(View.GONE);
                List<Album> albumList = albumResponse.getData();
                albumArrayList.addAll(albumList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClicked(Album album) {
        Intent intent = new Intent(AlbumActivity.this, PlayListArtistActivity.class);
        String key = album.getTitle();
        String link = album.getLink();
        intent.putExtra("link",link);
        intent.putExtra("name", key);
        String picture = album.getCoverBig();
        intent.putExtra("picture", picture);
        startActivity(intent);

    }
}