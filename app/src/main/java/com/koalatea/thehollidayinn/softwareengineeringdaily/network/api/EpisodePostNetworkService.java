package com.koalatea.thehollidayinn.softwareengineeringdaily.network.api;

import com.koalatea.thehollidayinn.softwareengineeringdaily.network.response.PostResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by krh12 on 6/17/2017.
 */

public interface EpisodePostNetworkService {

    @GET("posts")
    Observable<List<PostResponse>> getAllPosts();

    @GET("posts?type=top")
    Observable<List<PostResponse>> getTopPosts();

    @GET("posts?type=top")
    Observable<List<PostResponse>> getTopPostsBySearch(@Query("search") String searchString);

    @GET("posts")
    Observable<List<PostResponse>> getPostsByCategory(@Query("categories") long categoryId);

    @GET("posts")
    Observable<List<PostResponse>> getPostBySearchString(@Query("search") String searchString);

    @GET("posts")
    Observable<List<PostResponse>> getPostByCategoryAndSearch(
        @Query("categories") long categoryId,
        @Query("search") String searchString);

    @GET("posts/recommendations")
    Observable<List<PostResponse>> getRecommendations();

    @GET("posts/recommendations")
    Observable<List<PostResponse>> getRecommendationsBySearch(
      @Query("search") String searchString);

    @POST("posts/{postid}/upvote")
    Completable upVote(@Path("postid") String postId);

    @POST("posts/{postid}/downvote")
    Completable downVote(@Path("postid") String postId);
}
