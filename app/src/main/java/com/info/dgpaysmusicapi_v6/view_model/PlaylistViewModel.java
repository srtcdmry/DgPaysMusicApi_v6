package com.info.dgpaysmusicapi_v6.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.info.dgpaysmusicapi_v6.repository.PlaylistRepository;
import com.info.dgpaysmusicapi_v6.response.PlaylistResponse;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class PlaylistViewModel extends AndroidViewModel {

    private PlaylistRepository playlistRepository;
    private LiveData<PlaylistResponse> playlistResponseLiveData;
    @Inject
    public PlaylistViewModel(@NonNull Application application) {

        super(application);
        playlistRepository = new PlaylistRepository();
        this.playlistResponseLiveData = playlistRepository.PlaylistResponse();
    }

    public LiveData<PlaylistResponse> getPlaylistResponseLiveData(){
        return playlistResponseLiveData;
    }

}