package com.example.philip.chainsaw.apis;

import com.example.philip.chainsaw.model.Match;
import com.example.philip.chainsaw.model.test.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by philip on 5/21/17.
 */

public interface TinderServiceRetrofit {
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //Tinder calls
    //Insert user model
    @POST("auth")
    Call<Response> authUser(@Query("facebook_token") String accessToken, @Query("facebook_id") String facebookId);

    @GET("user/recs")
    Call<List<Post>> getRecs();

    //Might be get method
    @POST("like|pass/{_id}")
    Call<Response> likeUser(@Path("_id") String id);

    @POST("pass/{_id}")
    Call<ResponseBody> passUser(@Path("_id") String id);

    @POST("updates")
    Call<List<Match>> getMessages(@Header("X-Auth-Token") String tinderToken);

     /*Retrofit builder = new Retrofit.Builder().baseUrl("https://api.gotinder.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        TinderServiceRetrofit tsr = builder.create(TinderServiceRetrofit.class);

        Call<List<Match>> matches = tsr.getMessages("octocat");
        matches.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {

            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {

            }
        });*/
}