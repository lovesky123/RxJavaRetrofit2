package com.xulc.kitdemo.network;

import com.xulc.kitdemo.base.BaseResponse;
import com.xulc.kitdemo.bean.ArticleData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //1.首页相关
    /**
     * 1.1首页文章列表
     * @param page 页码，拼接在连接中，从0开始。
     * @return
     */
    @GET("/article/list/{page}/json")
    Observable<BaseResponse<ArticleData>> getHomeArticles(@Path("page") int page);

}
