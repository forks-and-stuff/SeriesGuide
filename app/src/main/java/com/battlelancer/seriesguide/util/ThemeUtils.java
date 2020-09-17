package com.battlelancer.seriesguide.util;

import android.content.Context;
import androidx.annotation.AttrRes;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import com.battlelancer.seriesguide.R;
import com.battlelancer.seriesguide.ui.SeriesGuidePreferences;
import com.uwetrottmann.androidutils.AndroidUtils;

/**
 * Helper methods to support SeriesGuide's different themes.
 */
public class ThemeUtils {

    /**
     * Sets the global app theme variable. Applied by all activities once they are created.
     */
    public static synchronized void updateTheme(String themeIndex) {
        SeriesGuidePreferences.THEME = R.style.Theme_SeriesGuide_DayNight;
        int theme = Integer.parseInt(themeIndex);
        switch (theme) {
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            default:
                // Defaults as recommended by https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94
                if (AndroidUtils.isAtLeastAndroid10()) {
                    AppCompatDelegate
                            .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                } else {
                    AppCompatDelegate
                            .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                }
                break;
        }
    }

    public static int getColorFromAttribute(Context context, @AttrRes int attribute) {
        return ContextCompat.getColor(
                context,
                Utils.resolveAttributeToResourceId(context.getTheme(), attribute)
        );
    }
}
