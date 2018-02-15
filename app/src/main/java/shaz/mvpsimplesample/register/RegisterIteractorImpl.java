package shaz.mvpsimplesample.register;

import android.os.Handler;
import android.text.TextUtils;

import java.util.Random;

import shaz.mvpsimplesample.utils.Util;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public class RegisterIteractorImpl implements RegisterIteractor {
    @Override
    public void register(final String name, String email, String password, final OnRegisterFinishedListener listener) {
        if (TextUtils.isEmpty(name)) {
            listener.onNameError("Please enter your name");
            return;
        } else if (TextUtils.isEmpty(email)) {
            listener.onEmailError("Please enter your email address");
            return;
        } else if (TextUtils.isEmpty(password)) {
            listener.onPasswordError("Please enter password");
            return;
        } else if (name.length() > 20) {
            listener.onNameError("Name field limit exceeds");
            return;
        } else if (!Util.isValidEmail(email)) {
            listener.onEmailError("Please enter valid email address");
            return;
        } else if (password.trim().replaceAll(" ", "").length() < 6) {
            listener.onPasswordError("Password should not be less than 6 character");
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (name.equalsIgnoreCase("Shahbaz")) {
                    listener.onUserExists();
                    return;
                }
                listener.onSuccess(name.trim().replaceAll(" ", "") + new Random().nextInt(1000));
            }
        }, 2000);
    }
}
