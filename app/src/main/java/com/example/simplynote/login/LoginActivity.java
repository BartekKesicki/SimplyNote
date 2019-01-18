package com.example.simplynote.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simplynote.R;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

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
        ButterKnife.bind(this);
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
    public void clearErrors() {
        loginEdittext.setError(null);
        passwordEdittext.setError(null);
    }
}
