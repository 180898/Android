package santos.williankaminski.festafimdeano.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("FimDeAno", Context.MODE_PRIVATE);
    }

    public void storageString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStorageString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }
}
