package com.info.dgpaysmusicapi_v6.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.dgpaysmusicapi_v6.constants.AppConstants;
import com.info.dgpaysmusicapi_v6.response.TrackResponse;
import com.info.dgpaysmusicapi_v6.retrofit.ApiRequest;
import com.info.dgpaysmusicapi_v6.retrofit.RetrofitRequest;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackRepository {

    private static final String TAG = TrackRepository.class.getSimpleName();
    private  ApiRequest apiRequest;

    @Inject
    public TrackRepository(ApiRequest apiRequest){
        this.apiRequest=apiRequest;
    }

    public LiveData<TrackResponse> TrackResponse() {
        final MutableLiveData<TrackResponse> data = new MutableLiveData<>();
        apiRequest.getTrackResponse(AppConstants.search)
                .enqueue(new Callback<TrackResponse>() {
                    @Override
                    public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<TrackResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
