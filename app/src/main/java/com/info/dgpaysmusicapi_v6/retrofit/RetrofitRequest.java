package com.info.dgpaysmusicapi_v6.retrofit;

import static com.info.dgpaysmusicapi_v6.constants.AppConstants.BASE_URL;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitRequest {


    @Provides
    @Singleton
    public static ApiRequest provideApiRequest(){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiRequest.class);
    }
}
