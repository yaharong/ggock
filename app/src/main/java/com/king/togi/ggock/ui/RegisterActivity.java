package com.king.togi.ggock.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.king.togi.ggock.R;

/**
 * Created by Tacademy on 2017-08-04.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText email, pw;
    String sEmail, sPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email = (EditText) findViewById(R.id.email);
        pw = (EditText) findViewById(R.id.pw);

        sEmail = email.getText().toString();
        sPw = pw.getText().toString();
    }

// 회원가입 메소드

    public void onJoin(View view) {

        String sEmail = this.email.getText().toString();
        String sPw = this.pw.getText().toString();
        //2. 유효성 검사 (입력 않하면 X, 형식이 틀리면 X, ...)
        if (TextUtils.isEmpty(sEmail)) {
            email.setError("이메일을 입력하세요.");
            return;
        }
        if (TextUtils.isEmpty(sPw)) {
            pw.setError("비밀번호를 입력하세요.");
            return;
        }

//        Req_join req_join = new Req_join();
//        req_join.setUser(new User(
//                0,              // 임시값(서버세팅)
//                email,
//                password,
//                null,           // 임시값(서버세팅)
//                "01022223333",  // 단말기에 추후추출
//                "a",
//                "ss",           // 단말기에서 추후 추출
//                "",             // 추후추출
//                ""              // firebase fcm 연동 후 추출
//        ));
//        Call<Res_join> res = Net.getInstance().getMemberFactoryIm().join(req_join);
//        // 응답 처리 작업
//        res.enqueue(new Callback<Res_join>() {
//            @Override
//            public void onResponse(Call<Res_join> call, Response<Res_join> response) {
//                if( response.isSuccessful() ){
//                    if( response.body() != null ){
//                        U.getInstance().log("회원가입성공공");
//                    }else{
//                        U.getInstance().log("통신 실패 1");
//                    }
//                }else{
//                    try {
//                        U.getInstance().log("통신 실패 2" + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            @Override
//            public void onFailure(Call<Res_join> call, Throwable t) {
//                U.getInstance().log("통신 실패 3" + t.getMessage());
//            }
//        });
    }
}
