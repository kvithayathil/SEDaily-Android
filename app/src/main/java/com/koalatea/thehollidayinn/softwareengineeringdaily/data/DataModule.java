package com.koalatea.thehollidayinn.softwareengineeringdaily.data;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;
import com.koalatea.thehollidayinn.softwareengineeringdaily.R;
import com.koalatea.thehollidayinn.softwareengineeringdaily.app.AppScope;
import com.koalatea.thehollidayinn.softwareengineeringdaily.data.mapper.PostItemMapper;
import com.koalatea.thehollidayinn.softwareengineeringdaily.data.preference.AuthPreference;
import com.koalatea.thehollidayinn.softwareengineeringdaily.data.preference.AuthPreferenceImpl;

import com.koalatea.thehollidayinn.softwareengineeringdaily.data.remote.EpisodeCategoryRepo;
import com.koalatea.thehollidayinn.softwareengineeringdaily.utils.LocalTextUtils;
import dagger.Module;
import dagger.Provides;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;

/**
 * Created by Kurian on 26-Sep-17.
 */
@Module
public class DataModule {

    public static final String DATA_CATEGORY_ID_MAP = "named_category_id_map";

    @Provides
    @AppScope
    @Named(DATA_CATEGORY_ID_MAP)
    Map<Integer, String> providesCategoryIdMap(@NonNull Resources resources) {
        final Map<Integer, String> map = new HashMap<>();
        final int[] idArray = resources.getIntArray(R.array.category_id_array);
        final String [] categoryArray = resources.getStringArray(R.array.category_name_array);

        for(int i = 0; i < idArray.length; i++) {
            map.put(idArray[i], categoryArray[i]);
        }
        return map;
    }

    @Provides
    @AppScope
    AuthPreference providesAuthPreference() {
        return new AuthPreferenceImpl();
    }

    @Provides
    @AppScope
    PostItemMapper providesPostItemMapper() {
        return new PostItemMapper();
    }

    @Provides
    @AppScope
    EpisodeCategoryRepo providesEpisodeCategoryRepo(@NonNull Map<Integer, String> map, @NonNull
        LocalTextUtils textUtils) {
        return new EpisodeCategoryRepo(map, textUtils);
    }
}
