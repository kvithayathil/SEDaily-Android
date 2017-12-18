package com.koalatea.thehollidayinn.softwareengineeringdaily.domain;

import android.support.annotation.NonNull;
import com.koalatea.thehollidayinn.softwareengineeringdaily.data.models.PostItem;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by Kurian on 26-Sep-17.
 */

public interface PostRepository {

    /**
     * Get all posts
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getPosts();

    /**
     * Get all posts from a specific category
     * @param categoryId id of the category to filter by
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getPostByCategory(long categoryId);

    /**
     * Get all posts from a specific category with a string filter
     * @param categoryId id of the category to filter by
     * @param filter string for additional filtering
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getPostsByCategoryWithFilter(long categoryId,
        String filter);

    /**
     * Get posts that fall within the matching search filter
     * @param filter string to filter posts by
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> findPosts(@NonNull String filter);

    /**
     * Add an upvote to a post
     * @param postId id of post to upvote
     * @return
     */
    Completable upVote(@NonNull String postId);

    /**
     * Add an upvote to a post
     * @param postId id of post to upvote
     * @return
     */
    Completable downVote(@NonNull String postId);

    /**
     * Get a list of the most popular posts
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getTopPosts();

    /**
     * Get a list of the most popular posts with additonal search filtering
     * @param filter string for additional filtering
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getTopPostsWithFilter(String filter);

    /**
     * Get a list of recommended posts
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getRecommendedPosts();

    /**
     * Get a list of recommended posts
     * @param filter string for additional filtering
     * @return List of {@link PostItem}
     */
    Observable<List<PostItem>> getRecommendedPostsWithFilter(String filter);
}
