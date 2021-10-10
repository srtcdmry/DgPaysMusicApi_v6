package com.info.dgpaysmusicapi_v6.viewModel;


import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.info.dgpaysmusicapi_v6.repository.TrackRepository;
import com.info.dgpaysmusicapi_v6.response.TrackResponse;


public class TrackViewModel extends ViewModel {

    private TrackRepository trackRepository;
    private LiveData<TrackResponse> trackResponseLiveData;
    @ViewModelInject
    public TrackViewModel(TrackRepository trackRepository) {
        this.trackRepository=trackRepository ;
        this.trackResponseLiveData = trackRepository.TrackResponse();
    }

    public LiveData<TrackResponse> getTrackResponseLiveData(){
        return trackResponseLiveData;
    }

}
