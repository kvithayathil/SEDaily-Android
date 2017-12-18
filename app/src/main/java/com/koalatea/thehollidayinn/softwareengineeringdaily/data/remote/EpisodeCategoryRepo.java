package com.koalatea.thehollidayinn.softwareengineeringdaily.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.Map;

/**
 * Created by Kurian on 16-Dec-17.
 */
public class EpisodeCategoryRepo {

  private final Map<Integer, String> categoryMap;

  public EpisodeCategoryRepo(Map<Integer, String> categoryMap) {
    this.categoryMap = categoryMap;
  }

  public int getCategoryIdFromName(@NonNull String categoryName) {
    if(categoryMap.containsValue(categoryName)) {
      for (int key : categoryMap.keySet()) {
        if (categoryMap.get(key) == categoryName) {
          return key;
        }
      }
    }
    return -1;
  }

  public String getCategoryNameFromId(@NonNull int id) {
    return categoryMap.get(id);
  }

  @VisibleForTesting
  void addCategory(int id, @NonNull String categoryName) {
     categoryMap.put(id, categoryName);
  }
}
