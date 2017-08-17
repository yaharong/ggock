package com.king.togi.ggock.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.facebook.CallbackManager;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;
import com.king.togi.ggock.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.helper.Utility.getPackageInfo;

public class LoginActivity extends AppCompatActivity {
    // kakao
    private SessionCallback callback;
    // facebook
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initFacebook();
        // kakao
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();
        Log.i("T", "#############################################################################");
        Log.i("T", "key : "+getKeyHash(this));
        Log.i("T", "#############################################################################");
    }
    public String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {

            }
        }
        return null;
    }
//    private void initFacebook() {
//        callbackManager = CallbackManager.Factory.create();
//        LoginButton loginButton = (LoginButton) findViewById(R.id.facebook_login);
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                startActivity(new Intent(LoginActivity.this, MyPageAuthActivity.class));
//                finish();
//            }
//
//            @Override
//            public void onCancel() {
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//            }
//        });
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // kakao
        if(Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)){
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            redirectSignupActivity();  // 세션 연결성공 시 redirectSignupActivity() 호출
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
            setContentView(R.layout.activity_login); // 세션 연결이 실패했을때
        }                                            // 로그인화면을 다시 불러옴
    }

    protected void redirectSignupActivity() {
        requestMe();
    }
    // kakao
    public void requestMe(){
        Log.i("T", "#############################################################################");
        Log.i("T", "requestMe");
        Log.i("T", "#############################################################################");
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                Log.i("T", "#############################################################################");
                Log.i("T", "onFailure");
                Log.i("T", "#############################################################################");
                super.onFailure(errorResult);
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                // 세션이 닫혔다
                Log.i("T", "onSessionClosed()");
            }
            @Override
            public void onNotSignedUp() {
                // 로그인으로 이동
                Log.i("T", "onNotSignedUp()");
            }
            @Override
            public void onSuccess(UserProfile result) {
                // 개인 프로필 획득
                Log.i("T", "#############################################################################");
                Log.i("T", "카카오 개인 정보 획득 성공");
                Log.i("T", "" + result.getNickname());
                Log.i("T", "" + result.getProfileImagePath());
                Log.i("T", "" + result.getThumbnailImagePath());
                Log.i("T", "" +  result.getUUID());
                Log.i("T", "" + result.getId());
                Log.i("T", "" + result.getServiceUserId());
                Log.i("T", "" + result.getProperties().toString());
                Log.i("T", "#############################################################################");
            }
        });
    }
    // kakao
    public void onKakaoLogout(View view){
        UserManagement.requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                // 화면처리
                Log.i("T", "카카오 로그아웃");
            }
        });
    }
}