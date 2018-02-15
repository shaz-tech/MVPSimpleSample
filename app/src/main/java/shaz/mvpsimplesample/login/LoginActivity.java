package shaz.mvpsimplesample.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import shaz.mvpsimplesample.R;
import shaz.mvpsimplesample.main.MainActivity;
import shaz.mvpsimplesample.register.RegisterActivity;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;
    private ProgressDialog progressDialog;

    private AppCompatEditText userName, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Login");
        }

        presenter = new LoginPresenterImpl(this, new LoginInteractorImpl());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging In...");

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        if (progressDialog != null)
            progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, "Logged In successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.TAG_EXTRA_USER_NAME, userName.getText().toString());
        startActivity(intent);
        finish();
    }

    public void login(View view) {
        presenter.validateCredential(userName.getText().toString(), password.getText().toString());
    }

    public void register(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
