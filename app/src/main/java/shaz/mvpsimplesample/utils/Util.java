package shaz.mvpsimplesample.utils;

import android.text.TextUtils;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public abstract class Util {
    private static final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public static boolean isValidEmail(String email) {
        if (TextUtils.isEmpty(email))
            return false;
        return email.matches(emailPattern);
    }
}
