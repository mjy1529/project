package org.androidtown.colorvel2;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends TabActivity { //TabActivity 상속받음
    //TabHost mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* TabHost 부분 */
        TabHost mTab = getTabHost(); //getTabHost 메소드를 통해 탭호스트 변수 생성
        TabHost.TabSpec spec; //탭 스펙 생성(Tab Spec : 탭을 구성하는 요소들의 집합)

        LayoutInflater.from(this).inflate(R.layout.activity_main, mTab.getTabContentView(), true); //화면 띄우기

        spec = mTab.newTabSpec("tab1").setIndicator("ALBUM").setContent(R.id.tab1); //화면에 보여지는 탭명이 ALBUM임
        mTab.addTab(spec); //탭 추가

        spec = mTab.newTabSpec("tab2").setIndicator("MAP").setContent(R.id.tab2);
        mTab.addTab(spec);

        spec = mTab.newTabSpec("tab3").setIndicator("COLOR").setContent(R.id.tab3);
        mTab.addTab(spec);

    }

    public void onClick(View v){ //버튼 클릭 이벤트 처리
        switch(v.getId()){ //버튼의 id에 따라 처리방식이 다름
            case R.id.moreImageButton: //moreImageButton이 눌렸을 경우
                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class); //인텐트 생성
                startActivity(albumIntent); //인텐트 실행

            case R.id.openLayout:
                Intent colorIntent = new Intent(getApplicationContext(), ColoringActivity.class);
                startActivity(colorIntent);

                break;
        }
    }

    /* 지역 선택 버튼 */
    /*public void districtButton(View v) {
        AlertDialog.Builder districtAlert = new AlertDialog.Builder(MainActivity.this);
        View districtView = getLayoutInflater().inflate(R.layout.district_dialog, null);
        districtAlert.setTitle("지역을 선택해주세요.");
        final Spinner spinner = (Spinner) districtView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.spinner1));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        districtAlert.setView(districtView);
        districtAlert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!spinner.getSelectedItem().toString().equalsIgnoreCase("도 선택")) {
                    Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        districtAlert.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        districtAlert.show();
    }*/

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}