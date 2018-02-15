package shaz.mvpsimplesample.login;

import shaz.mvpsimplesample.mvp.BasePresenter;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public interface LoginPresenter extends BasePresenter {
    void validateCredential(String userName, String password);
}
