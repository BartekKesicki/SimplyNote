package com.example.simplynote.register;

import android.text.TextUtils;

import com.example.simplynote.R;
import com.example.simplynote.repository.UserRepository;
import com.example.simplynote.room.model.User;
import com.example.simplynote.utils.BaseScheduler;
import com.example.simplynote.utils.StringProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class RegisterActivityPresenter implements RegisterContract.RegisterPresenter<RegisterContract.RegisterView> {

    RegisterContract.RegisterView view;

    private StringProvider mStringProvider;

    private UserRepository mUserRepository;

    private BaseScheduler mBaseScheduler;

    @Inject
    public RegisterActivityPresenter(StringProvider stringProvider, UserRepository userRepository, BaseScheduler baseScheduler) {
        this.mStringProvider = stringProvider;
        this.mUserRepository = userRepository;
        this.mBaseScheduler = baseScheduler;
    }

    @Override
    public void attach(RegisterContract.RegisterView view) {
        this.view = view;
    }

    void performToRegister(String login, String password, String confirmPassword) {
        if (TextUtils.isEmpty(login)) {
            view.setLoginError(mStringProvider.getString(R.string.registration_this_field_cant_be_empty));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            view.setPasswordError(mStringProvider.getString(R.string.registration_this_field_cant_be_empty));
            return;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            view.setConfirmPasswordMessage(mStringProvider.getString(R.string.registration_this_field_cant_be_empty));
            return;
        }
        if (!password.equals(confirmPassword)) {

            return;
        }
        final User user = new User();
        user.setLogin(login);
        user.setPassowrd(password);
        mUserRepository.getAll()
                .subscribeOn(mBaseScheduler.io())
                .observeOn(mBaseScheduler.main())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onSuccess(List<User> users) {
                        continueUserVerification(users, user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo check error
                    }
                });
    }

    private void continueUserVerification(List<User> users, User user) {
        for (User examinedUser : users) {
            if (examinedUser.getLogin().equals(user.getLogin()) && examinedUser.getPassowrd().equals(user.getPassowrd())) {
                view.setLoginError(mStringProvider.getString(R.string.registration_user_already_exists));
                return;
            }
        }
        mUserRepository.insert(user)
                .subscribeOn(mBaseScheduler.io())
                .observeOn(mBaseScheduler.main())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        view.showToast(mStringProvider.getString(R.string.registration_user_added_message));
                        view.redirectToLoginActivity();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showToast(mStringProvider.getString(R.string.registration_user_insertion_failed));
                    }
                });
    }

    @Override
    public void detach() {
        view = RegisterContract.NULL;
    }
}
