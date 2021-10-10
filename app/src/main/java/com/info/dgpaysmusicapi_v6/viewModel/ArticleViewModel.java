package com.info.dgpaysmusicapi_v6.viewModel;


import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.info.dgpaysmusicapi_v6.repository.ArticleRepository;
import com.info.dgpaysmusicapi_v6.response.ArticleResponse;



public class ArticleViewModel extends ViewModel {

    private final ArticleRepository articleRepository;
    private final LiveData<ArticleResponse> articleResponseLiveData;

    @ViewModelInject
    public ArticleViewModel(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.articleResponseLiveData = articleRepository.getDashBoardNews();
    }

    public LiveData<ArticleResponse> getBashboardNewsResponseLiveData() {
        return articleResponseLiveData;
    }

}
