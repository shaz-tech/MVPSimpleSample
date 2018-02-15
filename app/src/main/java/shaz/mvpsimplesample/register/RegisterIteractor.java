package shaz.mvpsimplesample.register;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public interface RegisterIteractor {
    interface OnRegisterFinishedListener {
        void onNameError(String errorMessage);

        void onEmailError(String errorMessage);

        void onPasswordError(String errorMessage);

        void onUserExists();

        void onNetworkError(String errorMessage);

        void onSuccess(String userName);
    }

    void register(String name, String email, String password, OnRegisterFinishedListener listener);
}
