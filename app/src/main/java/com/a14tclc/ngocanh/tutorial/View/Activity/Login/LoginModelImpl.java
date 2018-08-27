package com.a14tclc.ngocanh.tutorial.View.Activity.Login;

import android.util.Log;

import com.a14tclc.ngocanh.tutorial.Response.UserResponse;
import com.a14tclc.ngocanh.tutorial.service.TutorialAppApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModelImpl implements LoginModel {

    private TutorialAppApi mTutorialAppApi;

    public LoginModelImpl() {
        mTutorialAppApi = TutorialAppApi.Factory.create();
    }

    @Override
    public void login(final String username, String password) {
        /**
         * Here, you should use Retrofit library to get data from Server.
         * By the way, follow step by step below:
         * 1. You should create Object to parse.
         * Look json here: https://gettingblog.herokuapp.com/api
         * We separate two object: Message and User
         * File: TutorialAppApi.java contains all apis
         * File UserResponse, UserData, Message for parse data from Json to Object
         */
        Call<UserResponse> call = mTutorialAppApi.getUser();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                /**
                 * Show information of Object Error:
                 */
                Log.i("TAG", userResponse.getError().getStatus());
                Log.i("TAG", userResponse.getError().getDescription());

                /**
                 * Get list of users
                 */
                Log.i("TAG", "How many users: "+userResponse.getUserData().size());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }
        });
    }
}
