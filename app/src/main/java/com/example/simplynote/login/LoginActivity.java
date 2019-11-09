package com.example.simplynote.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;
import com.example.simplynote.register.RegisterActivity;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity implements LoginContract.LoginView {

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Inject
    LoginActivityPresenter presenter;

    @BindView (R.id.registration_button) Button registerButton;

    @BindView (R.id.submit_button) Button submitButton;

    @BindView (R.id.login_edittext) TextInputEditText loginEdittext;

    @BindView (R.id.password_edittext) TextInputEditText passwordEdittext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.attach(this);
        setButtonListeners();
    }

    private void setButtonListeners() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.performToRedirectToRegisterPage();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearErrors();
                try {
                    String login = loginEdittext.getText().toString();
                    String password = passwordEdittext.getText().toString();
                    presenter.performToLogin(login, password);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    String errorMessage = getString(R.string.login_incorrect_inputs_message);
                    setLoginErrorMessage(errorMessage);
                }
            }
        });
    }

    @Override
    public void setLoginErrorMessage(String message) {
        loginEdittext.setError(message);
    }

    @Override
    public void redirectToRegisterActivity() {
        RegisterActivity.start(this);
    }

    @Override
    public void redirectToHomePage() {
        //todo create home page
    }

    @Override
    public void clearErrors() {
        loginEdittext.setError(null);
        passwordEdittext.setError(null);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }
}
