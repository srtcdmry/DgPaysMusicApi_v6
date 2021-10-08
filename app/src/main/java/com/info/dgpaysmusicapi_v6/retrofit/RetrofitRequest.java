package com.info.dgpaysmusicapi_v6.retrofit;

import static com.info.dgpaysmusicapi_v6.constants.AppConstants.BASE_URL;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Module
@InstallIn(SingletonComponent.class)
public class RetrofitRequest {


    @Provides
    @Singleton
    public static Retrofit getRetrofitInstance(){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
}
