package com.koalatea.thehollidayinn.softwareengineeringdaily.data.remote;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.koalatea.thehollidayinn.softwareengineeringdaily.app.SDEApp;
import com.koalatea.thehollidayinn.softwareengineeringdaily.utils.LocalTextUtils;
import java.util.Map;

/**
 * Created by Kurian on 16-Dec-17.
 */
public class EpisodeCategoryRepo {

  private final Map<Integer, String> categoryMap;
  private final LocalTextUtils localTextUtils;

  public EpisodeCategoryRepo(Map<Integer, String> categoryMap, LocalTextUtils textUtils) {
    this.categoryMap = categoryMap;
    this.localTextUtils = textUtils;
  }

  public int getCategoryIdFromName(@NonNull String categoryName) {
    if(!categoryMap.isEmpty()) {
      for (int key : categoryMap.keySet()) {
        if (localTextUtils.equals(categoryMap.get(key), categoryName)) {
          return key;
        }
      }
    }
    return -1;
  }

  public String getCategoryNameFromId(@NonNull int id) {
    return categoryMap.get(id);
  }
}
