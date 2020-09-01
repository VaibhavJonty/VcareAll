package com.tuteehub.vcareall.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.tuteehub.vcareall.R;
import com.tuteehub.vcareall.adapter.FeedItemAdapter;
import com.tuteehub.vcareall.model.FeedRequest;
import com.tuteehub.vcareall.model.FeedResponse;
import com.tuteehub.vcareall.model.Msg;
import com.tuteehub.vcareall.rest.RestClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedActivity extends AppCompatActivity {

    @BindView(R.id.imgMenu)
    AppCompatImageView imgMenu;
    @BindView(R.id.txtToolBarTitle)
    MaterialTextView txtToolBarTitle;
    @BindView(R.id.rvFeed)
    RecyclerView rvFeed;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    FeedItemAdapter feedItemAdapter;
    FeedResponse feedResponse;
    List<Msg> feedList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvFeed.setLayoutManager(mLayoutManager);
        rvFeed.setHasFixedSize(true);
        feedList = new ArrayList<>();
        getFeedList("0","test");
    }

    @OnClick(R.id.imgMenu)
    public void onViewClicked() {
    }

    private void getFeedList(String fbId, String token) {
        progressBar.setVisibility(View.VISIBLE);
        JSONObject parameters = new JSONObject();
        try {
            parameters.put("fb_id", fbId);
            parameters.put("token", token);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        FeedRequest feedRequest = new FeedRequest(fbId,token);
        Call<FeedResponse> responseCall = RestClient.getClient().
                getFeedList(feedRequest);
        responseCall.enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                if (response.isSuccessful()) {
                    // request successful (status code 200, 201)
                    progressBar.setVisibility(View.GONE);
                    feedResponse = response.body();
                    if (feedResponse.getCode().equalsIgnoreCase("200")) {
                        if (!feedResponse.getMsg().isEmpty()) {
                            feedList.addAll(feedResponse.getMsg());
                            if (feedItemAdapter == null) {
                                feedItemAdapter = new FeedItemAdapter(FeedActivity.this,feedList);
                                rvFeed.setAdapter(feedItemAdapter);
                            } else {
                                feedItemAdapter.notifyDataSetChanged();
                            }

                        } else {
                            showToast("No data found");
                        }

                    } else {
                        showToast("Please try again");
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    Log.d("onFailure : ", response.message());
                }
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d("onFailure : ", t.getMessage());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}