package com.info.dgpaysmusicapi_v6.viewModel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.info.dgpaysmusicapi_v6.repository.PlaylistRepository;
import com.info.dgpaysmusicapi_v6.response.PlaylistResponse;


public class PlaylistViewModel extends ViewModel {

    private  PlaylistRepository playlistRepository;
    private final LiveData<PlaylistResponse> playlistResponseLiveData;

    @ViewModelInject
    public PlaylistViewModel(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
        this.playlistResponseLiveData = playlistRepository.PlaylistResponse();
    }

    public LiveData<PlaylistResponse> getPlaylistResponseLiveData() {
        return playlistResponseLiveData;
    }

}