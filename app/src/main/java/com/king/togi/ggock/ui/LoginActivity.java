package com.king.togi.ggock.ui;

import android.support.v7.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
//
//    private CallbackManager callbackManager;
//    private InputMethod.SessionCallback kakaocallback;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        initFacebook();
//        kakaocallback = new SessionCallback();
//        Session.getCurrentSession().addCallback(kakaocallback);
//    }
//
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
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)){
//            return;
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Session.getCurrentSession().removeCallback(kakaocallback);
//    }
//
//    private class SessionCallback implements ISessionCallback {
//
//        @Override
//        public void onSessionOpened() {
//            redirectSignupActivity();  // 세션 연결성공 시 redirectSignupActivity() 호출
//        }
//
//        @Override
//        public void onSessionOpenFailed(KakaoException exception) {
//            if(exception != null) {
//                Logger.e(exception);
//            }
//            setContentView(R.layout.activity_login); // 세션 연결이 실패했을때
//        }                                            // 로그인화면을 다시 불러옴
//    }
//
//    protected void redirectSignupActivity() {       //세션 연결 성공 시 SignupActivity로 넘김
//        final Intent intent = new Intent(this, KakaoActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        startActivity(intent);
//        finish();
//    }
}