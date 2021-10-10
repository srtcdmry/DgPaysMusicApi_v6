package com.info.dgpaysmusicapi_v6.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.dgpaysmusicapi_v6.constants.AppConstants;
import com.info.dgpaysmusicapi_v6.response.AlbumResponse;
import com.info.dgpaysmusicapi_v6.retrofit.ApiRequest;
import com.info.dgpaysmusicapi_v6.retrofit.RetrofitRequest;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private static final String TAG = AlbumRepository.class.getSimpleName();
    private  ApiRequest apiRequest;

     @Inject
    public AlbumRepository(ApiRequest apiRequest){
         this.apiRequest=apiRequest;
    }

    public LiveData<AlbumResponse> AlbumResponse() {
        final MutableLiveData<AlbumResponse> data = new MutableLiveData<>();
        apiRequest.getAlbumResponse(AppConstants.search)
                .enqueue(new Callback<AlbumResponse>() {
                    @Override
                    public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<AlbumResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
