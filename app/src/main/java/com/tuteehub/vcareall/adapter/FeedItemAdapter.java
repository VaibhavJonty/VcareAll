package com.tuteehub.vcareall.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.tuteehub.vcareall.R;
import com.tuteehub.vcareall.model.Msg;

import org.apache.http.util.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FeedItemAdapter extends RecyclerView.Adapter<FeedItemAdapter.ViewHolder> {
    Context context;
    List<Msg> feedList;

    public FeedItemAdapter(Context context, List<Msg> feedList) {
        this.context = context;
        this.feedList = feedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg feedItem = feedList.get(position);
        if(TextUtils.isEmpty(feedItem.getUserInfo().getFirstName())){
            holder.txtUserName.setText(feedItem.getUserInfo().getFirstName());
        }
        if (!TextUtils.isEmpty(feedItem.getUserInfo().getProfilePic())) {
            Glide.with(context).load(feedItem.getUserInfo().getProfilePic()).into(holder.imgProfilePic);
        }
        holder.txtUpdateTime.setText(feedItem.getCreated());
        holder.txtFeedItemTitle.setText(feedItem.getDescription());
        if (!TextUtils.isEmpty(feedItem.getThum())) {
            Glide.with(context).load(feedItem.getThum()).into(holder.imgFeedItem);
        }
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }



    static public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgProfilePic)
        ShapeableImageView imgProfilePic;
        @BindView(R.id.txtUserName)
        MaterialTextView txtUserName;
        @BindView(R.id.txtUpdateTime)
        MaterialTextView txtUpdateTime;
        @BindView(R.id.imgFeedMenu)
        ImageView imgFeedMenu;
        @BindView(R.id.imgFeedItem)
        AppCompatImageView imgFeedItem;
        @BindView(R.id.txtFeedItemTitle)
        MaterialTextView txtFeedItemTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



}
