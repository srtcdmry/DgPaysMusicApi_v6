package com.info.dgpaysmusicapi_v6.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.info.dgpaysmusicapi_v6.repository.TrackRepository;
import com.info.dgpaysmusicapi_v6.response.TrackResponse;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class TrackViewModel extends AndroidViewModel {

    private TrackRepository trackRepository;
    private LiveData<TrackResponse> trackResponseLiveData;
    @Inject
    public TrackViewModel(@NonNull Application application) {

        super(application);
        trackRepository = new TrackRepository();
        this.trackResponseLiveData = trackRepository.TrackResponse();
    }

    public LiveData<TrackResponse> getTrackResponseLiveData(){
        return trackResponseLiveData;
    }

}
