package shaz.mvpsimplesample.login;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener{
        void onLoginError(String errorMessage);
        void onLoginSuccess();
    }

    void login(String userName, String password, OnLoginFinishedListener listener);
}
