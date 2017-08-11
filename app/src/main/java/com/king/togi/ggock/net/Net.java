package com.king.togi.ggock.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tacademy on 2017-06-30.
 */
public class Net {
    // 싱글톤의 생성자는 private하기 때문에 자기자신밖에 호출할수없다.
    private Net() {
    }

    // private 수식어가 붙으면 이 클래스 내에서 밖에 사용할 수 없고
    // static 이라는 수식어가 붙으면 정적으로 메모리 가장 꼭대기에 유일하게 만들어진다
    // 자신안에서 자신을 생성하고 private로 막아버리기 때문에 본 클래스의 객체는 유일해진다.
    private static Net ourInstance = new Net();

    // 하지만 ourInstance 변수는 privqte 하여 건드릴수없으므로 getInstance 함수를 이용하여 접근한다.
    public static Net getInstance() {
        return ourInstance;
    }

    // ============================================================
    private Retrofit retrofit = new Retrofit.Builder()
            // 에뮬용 도메인
            //.baseUrl("http://10.0.2.2:3000")
            // 에뮬용 도메인
            //.baseUrl("http://localhost:3000")
            // 기본 도메인 설정
            //.baseUrl("http://apis.daum.net")
            // 내 폰에서 테스트가능한 아마존 서버
            //.baseUrl("http://ec2-52-79-174-137.ap-northeast-2.compute.amazonaws.com:3000")
            .baseUrl("http://52.78.224.134:3000")   // 우리서버

            .addConverterFactory(GsonConverterFactory.create()) // 응답 데이터를 json 자동 변환
            .build();

    public Retrofit getRetrofit() {
        return retrofit;
    }
    // ============================================================
    // API 담당 인터페이스 생성

    // API 담당 인터페이스의 객체를 생성
    DaumFactoryIm daumFactoryIm;

    // 객체를 리턴해주는 Getter 준비
    public DaumFactoryIm getDaumFactoryIm() {
        if (daumFactoryIm == null) // retroit은 확실히 만들지만, daumFactoryIm 사용할 때 만들곘다는 구성
        {
            // 인터페이스로 정의된 메소드를 사용할 수 있게 객체화 시켜준다.
            daumFactoryIm = retrofit.create(DaumFactoryIm.class);
        }
        return daumFactoryIm;
    }
}
