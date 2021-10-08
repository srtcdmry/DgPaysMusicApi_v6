package com.info.dgpaysmusicapi_v6.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.info.dgpaysmusicapi_v6.repository.ArticleRepository;
import com.info.dgpaysmusicapi_v6.response.ArticleResponse;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
@HiltViewModel
public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;
    @Inject
    public ArticleViewModel(@NonNull Application application) {

        super(application);
        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashBoardNews();
    }

    public LiveData<ArticleResponse> getBashboardNewsResponseLiveData(){
        return articleResponseLiveData;
    }

}
