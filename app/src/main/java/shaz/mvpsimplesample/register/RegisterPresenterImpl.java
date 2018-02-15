package shaz.mvpsimplesample.register;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public class RegisterPresenterImpl implements RegisterPresenter, RegisterIteractor.OnRegisterFinishedListener {

    private RegisterView view;
    private RegisterIteractor iteractor;

    public RegisterPresenterImpl(RegisterView view, RegisterIteractor iteractor) {
        this.view = view;
        this.iteractor = iteractor;
    }

    @Override
    public void onResume() {
        if (view != null)
            view.resetUi();
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
    public void registerUser(String name, String email, String password) {
        if (view != null)
            view.showProgress();
        iteractor.register(name, email, password, this);
    }

    @Override
    public void onNameError(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.showNameError(errorMessage);
        }
    }

    @Override
    public void onEmailError(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.showEmailError(errorMessage);
        }
    }

    @Override
    public void onPasswordError(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.showPasswordError(errorMessage);
        }
    }

    @Override
    public void onUserExists() {
        if (view != null) {
            view.hideProgress();
            view.showError("User already exists");
        }
    }

    @Override
    public void onNetworkError(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.showError(errorMessage);
        }
    }

    @Override
    public void onSuccess(String userName) {
        if (view != null) {
            view.hideProgress();
            view.showSuccess(userName);
            view.navigateToHome();
        }
    }
}
