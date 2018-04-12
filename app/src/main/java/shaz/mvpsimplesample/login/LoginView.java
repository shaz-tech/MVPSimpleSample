package shaz.mvpsimplesample.login;

import shaz.mvpsimplesample.base.BaseView;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public interface LoginView extends BaseView{
    void showErrorMessage(String errorMessage);
    void showSuccessMessage();
    void navigateToHome();
}
