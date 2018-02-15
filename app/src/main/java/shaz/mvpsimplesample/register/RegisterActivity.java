package shaz.mvpsimplesample.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import shaz.mvpsimplesample.R;
import shaz.mvpsimplesample.main.MainActivity;

/**
 * Created by ${Shahbaz} on 08-02-2018
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterPresenter presenter;
    private ProgressDialog progressDialog;

    private AppCompatEditText name, email, password;

    private String userNameValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Register");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        presenter = new RegisterPresenterImpl(this, new RegisterIteractorImpl());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Yoy!! Registering you...");

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
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
    public void showNameError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmailError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String userName) {
        userNameValue = userName;
        Toast.makeText(this, "Registered successfully with user name as " + userName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resetUi() {
        name.setText(null);
        email.setText(null);
        password.setText(null);
        name.requestFocus();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.TAG_EXTRA_USER_NAME, userNameValue);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void register(View view) {
        presenter.registerUser(name.getText().toString(), email.getText().toString(), password.getText().toString());
    }
}
