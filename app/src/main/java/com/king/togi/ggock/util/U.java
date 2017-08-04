package com.king.togi.ggock.util;

import android.util.Log;

/**
 * Created by Tacademy on 2017-07-17.
 * 유틸리티
 */

class U {
    private static final U ourInstance = new U();

    static U getInstance() {
        return ourInstance;
    }

    private U() {
    }

/*    // ==========================================================
    // 17.07.17 - API 를 쓸 땐 이렇ㄱ ㅔ이쁘게 포장해서 꺼내쓰세요
    public void showPopup3(Context context, String title, String msg,
                           String cName, SweetAlertDialog.OnSweetClickListener cEvent,
                           String oName, SweetAlertDialog.OnSweetClickListener oEvent) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)

                .setContentText(msg)
                .setConfirmText(oName)

                .setConfirmClickListener(oEvent)

                .setCancelText(cName)
                .setCancelClickListener(cEvent)
                .show();
    }

    // 17.07.17 - 2:54 : 로딩 바 API 포장하기
    public SweetAlertDialog showLoading(Context context) {
//        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading");
//        pDialog.setCancelable(false);   // 사용자가 back 키를 눌러도 창이 닫히지 않음 <= 이렇게 할 거면 해당 함수의 리턴 타입을 SweetAlertDialog 로 바꿔야한다.
//        pDialog.show();
//        return pDialog;
        return showLoading(context, "LOADING");
    }

    // 17.07.17 - 2:57 : 메소드 오버로딩( 매개변수만 다름 ) / 오버라이딩 ( 정의 내용이 다름 )
    public SweetAlertDialog showLoading(Context context, String msg) {
//        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText(msg);
//        pDialog.setCancelable(false);   // 사용자가 back 키를 눌러도 창이 닫히지 않음 <= 이렇게 할 거면 해당 함수의 리턴 타입을 SweetAlertDialog 로 바꿔야한다.
//        pDialog.show();
//        return pDialog; // 던져줘서 닫아줘야한다.
        return showLoading(context, "LOADING", "#A5DC86");
    }

    public SweetAlertDialog showLoading(Context context, String msg, String color) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(color));
        pDialog.setTitleText(msg);
        pDialog.setCancelable(false);   // 사용자가 back 키를 눌러도 창이 닫히지 않음 <= 이렇게 할 거면 해당 함수의 리턴 타입을 SweetAlertDialog 로 바꿔야한다.
        pDialog.show();
        return pDialog; // 던져줘서 닫아줘야한다.
    }

    // 17.07.17 - 2:54 : 심플 메시지 팝업창 API 포장하기( 매개변수 세팅 )
    public void showSimplePopup(Context context, String title, String msg, int type) {
        new SweetAlertDialog(context, type)   //SweetAlertDialog.ERROR_TYPE 를 쓰면 에러 표시 뜸
                .setTitleText(title)
                .setContentText(msg)
                .show();
    }

    // 17-07-18 - 13:42 : 버튼 하나짜리, 이벤트 걸리는 팝업창 만들기 ( 리턴값을 주면 이벤트 걸 수 있다. )
    public SweetAlertDialog showPopup(Context context, String title, String msg, int type) {
        SweetAlertDialog alert = new SweetAlertDialog(context, type);   //SweetAlertDialog.ERROR_TYPE 를 쓰면 에러 표시 뜸
        alert.setTitleText(title).setContentText(msg).setCancelable(false);
        alert.show();
        return alert;
    }*/

    // 17-07-18 - 11:34 : Log
    final String TAG = "TOGI";
    boolean isTestMode = true;

    public void log(String m) {
        if (isTestMode)  // testMode 가 true 일 떄만 로그찍힘

        Log.i(TAG, m + "");    // 로그 찍다가 죽지않게 방지, 로그는 null만 못찍음
    }

    // 버스 통신
//
//    // 17-07-18 - 13:56 : 버스
//    Bus gpsBus = new Bus();
//
//    public Bus getGpsBus() {
//        return gpsBus;
//    }
//
//    // =============================================================================
//    // 17-07-18 - 15:36 : address 를 받아서 시군구동 표시
//    public String getTransferAddr(Address address) {
//        if (address == null) return "";
//        else {
//            return String.format("%s %s %s", address.getAdminArea(), address.getLocality(), address.getThoroughfare());
//        }
//    }
//
//    // 17-07-19 - 9:33 : 좌표 변환 KATEC => GEO
//    public GeoPoint transGeoToKatec(GeoPoint point)
//    {
//    return GeoTrans.convert(GeoTrans.KATEC , GeoTrans.GEO, point);
//    }
//    // 17-07-21 - 14:55 : 좌표 변환 KATEC => GEO
//    public double getDouble(String src)
//    {
//        try {
//            return Double.parseDouble(src);
//            // parse는 항상 NumberFormatException을 들고있다.(code->surround with->try/catch)
//        } catch (NumberFormatException e) {
//            return 0;
//        }
//    }
//    public String changeBrand(String brand)
//    {
//        if (brand.equals("스타벅스"))
//        {
//            return "starbucks";
//        }else if(brand.equals("커피빈"))
//        {
//            return "coffeebean";
//        }
//        return "";
//
//    }



}
