package com.example.simplynote.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.simplynote.R;
import com.example.simplynote.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class RegisterActivity extends BaseActivity implements RegisterContract.RegisterView {

    public static void start(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @BindView(R.id.submit_button) Button submitButton;

    @BindView(R.id.login_edittext) EditText loginEditText;

    @BindView(R.id.password_edittext) EditText passwordEditText;

    @BindView(R.id.confirm_password_edittext) EditText confirmPasswordEditText;

    @Inject
    RegisterActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter.attach(this);
        setButtonListeners();
    }

    private void setButtonListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAllErrors();
                presenter.performToRegister(loginEditText.getText().toString(), passwordEditText.getText().toString(), confirmPasswordEditText.getText().toString());
            }
        });
    }

    @Override
    public void setLoginError(String message) {
        loginEditText.setError(message);
    }

    @Override
    public void setPasswordError(String message) {
        passwordEditText.setError(message);
    }

    @Override
    public void setConfirmPasswordMessage(String message) {
        confirmPasswordEditText.setError(message);
    }

    @Override
    public void clearAllErrors() {
        loginEditText.setError(null);
        passwordEditText.setError(null);
        confirmPasswordEditText.setError(null);
    }
}
