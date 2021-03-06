package com.koalatea.thehollidayinn.softwareengineeringdaily.podcast;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koalatea.thehollidayinn.softwareengineeringdaily.R;
import com.koalatea.thehollidayinn.softwareengineeringdaily.data.models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krh12 on 5/22/2017.
 */

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.ViewHolder> {
    private List<Post> posts = new ArrayList<>();
    private List<MediaBrowserCompat.MediaItem> mediaItemList;
    private PodListFragment context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView scoreTextView;
        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.card_title);
//            scoreTextView = (TextView) v.findViewById(R.id.score);
            imageView = (ImageView) v.findViewById(R.id.card_image);
        }
    }

    public PodcastAdapter(Fragment context) {
        mediaItemList = new ArrayList<>();
        this.context = (PodListFragment) context;
    }

    public void add(MediaBrowserCompat.MediaItem item) {
        mediaItemList.add(item);
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        this.notifyDataSetChanged();
    }

    @Override
    public PodcastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        final View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_podcast_list, parent, false);

        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = viewHolder.getAdapterPosition();
                Post post = posts.get(position);
                Intent intent = new Intent(context.getActivity(), PodcastDetailActivity.class);
                intent.putExtra("POST_ID", post._id);
                context.getActivity().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.mTextView.setText(post.title.rendered);
//        holder.scoreTextView.setText(String.valueOf(post.score));

        String imageLink = "https://softwareengineeringdaily.com/wp-content/uploads/2015/08/sed21.png";
        if (post.featuredImage != null) {
            imageLink = post.featuredImage;
        }
        Picasso.with(context.getContext()).load(imageLink).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}