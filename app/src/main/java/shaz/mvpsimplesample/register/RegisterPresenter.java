package shaz.mvpsimplesample.register;

import shaz.mvpsimplesample.base.BasePresenter;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public interface RegisterPresenter extends BasePresenter {
    void registerUser(String name, String email, String password);
}
