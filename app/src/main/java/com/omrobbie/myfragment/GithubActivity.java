package com.omrobbie.myfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.omrobbie.myfragment.api.GithubAPI;
import com.omrobbie.myfragment.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubActivity extends AppCompatActivity {

    private TextView tv_login, tv_avatar_url;
    private ImageView iv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        setupEnv();
        loadData();
    }

    private void setupEnv() {
        tv_login = (TextView) findViewById(R.id.tv_login);
        tv_avatar_url = (TextView) findViewById(R.id.tv_avatar_url);
        iv_profile = (ImageView) findViewById(R.id.iv_profile);
    }

    private void loadData() {
        GithubAPI service = MyApp.getRest().getService();

        service.getUser("omrobbie").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    tv_login.setText(user.getLogin());
                    tv_avatar_url.setText(user.getAvatar_url());

                    Glide.with(GithubActivity.this)
                            .load(user.getAvatar_url())
                            .into(iv_profile);
                } else loadFailed();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loadFailed();
            }
        });
    }

    private void loadFailed() {
        Toast.makeText(this, "Failed to load data!", Toast.LENGTH_SHORT).show();
    }
}
