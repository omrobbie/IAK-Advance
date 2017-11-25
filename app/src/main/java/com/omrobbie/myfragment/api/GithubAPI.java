package com.omrobbie.myfragment.api;

import com.omrobbie.myfragment.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by omrobbie on 25/11/2017.
 */

public interface GithubAPI {

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
