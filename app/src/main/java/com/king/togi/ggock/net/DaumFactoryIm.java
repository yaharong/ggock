package com.king.togi.ggock.net;

import com.king.togi.ggock.model.TotalModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 통신 API를 선언한다. 구현X
 * Created by Tacademy on 2017-06-30.
 */

public interface DaumFactoryIm {

    // 보내는 게없으므로 매개변수없음
    @GET("togi")
    Call<TotalModel> togi();

}











