package com.example.simplynote.login;


import com.example.simplynote.R;
import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.room.model.User;
import com.example.simplynote.utils.BaseScheduler;
import com.example.simplynote.utils.StringProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LoginActivityPresenter implements LoginContract.LoginPresenter<LoginContract.LoginView> {

    private LoginContract.LoginView view;

    private StringProvider mStringProvider;

    private UserRepository mUserRepository;

    private BaseScheduler mBaseScheduler;

    @Inject
    public LoginActivityPresenter(StringProvider stringProvider, UserRepository userRepository, BaseScheduler baseScheduler) {
        this.mStringProvider = stringProvider;
        this.mUserRepository = userRepository;
        this.mBaseScheduler = baseScheduler;
    }

    @Override
    public void attach(LoginContract.LoginView view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = LoginContract.NULL;
    }

    public void performToRedirectToRegisterPage() {
        view.redirectToRegisterActivity();
    }

    public void performToLogin(final String login, final String password) {
        mUserRepository.getAll()
                .subscribeOn(mBaseScheduler.io())
                .observeOn(mBaseScheduler.main())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<User> users) {
                        verifyUser(users, login, password);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.setLoginErrorMessage(mStringProvider.getString(R.string.login_incorrect_inputs_message));
                    }
                });
    }

    private void verifyUser(List<User> users, String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassowrd().equals(password)) {
                view.redirectToHomePage();
                return;
            }
        }
        view.setLoginErrorMessage(mStringProvider.getString(R.string.login_incorrect_inputs_message));
    }
}
