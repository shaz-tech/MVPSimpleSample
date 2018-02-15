package shaz.mvpsimplesample.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String userName, final String password, final OnLoginFinishedListener listener) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            listener.onLoginError("User name is empty");
            return;
        } else if (TextUtils.isEmpty(password)) {
            listener.onLoginError("Password is empty");
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!userName.equalsIgnoreCase("Shahbaz")) {
                    listener.onLoginError("Invalid user name");
                    return;
                } else if (!password.equals("shaz")) {
                    listener.onLoginError("Invalid password");
                    return;
                }
                listener.onLoginSuccess();
            }
        }, 2000);
    }
}
