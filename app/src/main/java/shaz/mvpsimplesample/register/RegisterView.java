package shaz.mvpsimplesample.register;

import shaz.mvpsimplesample.mvp.BaseView;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public interface RegisterView extends BaseView {
    void showNameError(String errorMessage);

    void showEmailError(String errorMessage);

    void showPasswordError(String errorMessage);

    void showError(String errorMessage);

    void showSuccess(String userName);

    void resetUi();

    void navigateToHome();
}
