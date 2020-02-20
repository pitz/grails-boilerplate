
package boilerplate.utils

import com.google.gson.GsonBuilder

class GsonBuilderUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd"

    public static Object buildClassFromJson(String json, Object toObject) {
        return new GsonBuilder().setDateFormat(GsonBuilderUtils.DATE_FORMAT).create().fromJson(json, toObject)
    }
}