package com.info.dgpaysmusicapi_v6.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.info.dgpaysmusicapi_v6.repository.AlbumRepository;
import com.info.dgpaysmusicapi_v6.response.AlbumResponse;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AlbumViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;
    private LiveData<AlbumResponse> albumResponseLiveData;
    @Inject
    public AlbumViewModel(@NonNull Application application) {

        super(application);
        albumRepository = new AlbumRepository();
        this.albumResponseLiveData = albumRepository.AlbumResponse();
    }

    public LiveData<AlbumResponse> getAlbumResponseLiveData(){
        return albumResponseLiveData;
    }
}
