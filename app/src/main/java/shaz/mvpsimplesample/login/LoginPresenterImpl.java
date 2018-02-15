package shaz.mvpsimplesample.login;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view, LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void validateCredential(String userName, String password) {
        if (view != null)
            view.showProgress();
        interactor.login(userName, password, this);
    }

    @Override
    public void onResume() {
        //TODO
    }

    @Override
    public void onPause() {
        //TODO
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onLoginError(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.showErrorMessage(errorMessage);
        }
    }

    @Override
    public void onLoginSuccess() {
        if (view != null) {
            view.hideProgress();
            view.showSuccessMessage();
            view.navigateToHome();
        }
    }
}
