package com.info.dgpaysmusicapi_v6.viewModel;


import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.info.dgpaysmusicapi_v6.repository.AlbumRepository;
import com.info.dgpaysmusicapi_v6.response.AlbumResponse;



public class AlbumViewModel extends ViewModel {
    private final AlbumRepository albumRepository;
    private final LiveData<AlbumResponse> albumResponseLiveData;

    @ViewModelInject
    public AlbumViewModel(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
        this.albumResponseLiveData = albumRepository.AlbumResponse();
    }

    public LiveData<AlbumResponse> getAlbumResponseLiveData() {
        return albumResponseLiveData;
    }
}
