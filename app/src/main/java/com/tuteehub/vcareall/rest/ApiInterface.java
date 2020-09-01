package com.tuteehub.vcareall.rest;




import com.tuteehub.vcareall.model.FeedRequest;
import com.tuteehub.vcareall.model.FeedResponse;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Accept:application/json")

    //1
    @POST("/tictok/API/index.php?p=showAllVideos")
    Call<FeedResponse> getFeedList(@Body FeedRequest feedRequest);

}

