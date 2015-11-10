/*
 * FragmentListTest.java
 * classes : com.iflytek.voiceadsdemo.FragmentListTest
 * @author 周众
 * V 1.0.0
 * Create at 2015-9-8 下午4:24:20
 */
package com.iflytek.voiceadsdemo;

import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * com.iflytek.voiceadsdemo.FragmentListTest
 * 
 * @author 周众 <br/>
 *         create at 2015-9-8 下午4:24:20
 */
public class MyFragmentActivity extends FragmentActivity implements OnClickListener {
  private static final String TAG = "FragmentActivity";
  private FragmentManager fm;
  private FragmentTransaction ft;
  private FragmentA fgma;
  private FragmentA fgmb;
  private FragmentB fgmc;
  private final int FRAGMENT_NUM=27;
//  private FragmentA2[] fgm=new FragmentA2[FRAGMENT_NUM];
  private TextView tv_fragmenta;
  private TextView tv_fragmentb;
  private TextView tv_fragmentc;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragmenttest);
    init();
  }
  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
  private void init() {
    tv_fragmenta=(TextView) findViewById(R.id.tv_fragmenta);
    tv_fragmentb=(TextView) findViewById(R.id.tv_fragmentb);
    tv_fragmentc=(TextView) findViewById(R.id.tv_fragmentc);
    tv_fragmenta.setOnClickListener(this);
    tv_fragmentb.setOnClickListener(this);
    tv_fragmentc.setOnClickListener(this);
    initFragment();
  }

  private void initFragment() {

    fgma = new FragmentA();
    fgmb = new FragmentA();
    fgmc = new FragmentB();
    fm = getSupportFragmentManager();
    ft = fm.beginTransaction();
//    {
//    ft.add(R.id.fragmentContainer, fgma);
//
//    }
      {  
    ft.add(R.id.fragmentContainer, fgma).hide(fgma);
    ft.add(R.id.fragmentContainer, fgmb).hide(fgmb);
    ft.add(R.id.fragmentContainer, fgmc).hide(fgmc);
    ft.show(fgma);
  }
    ft.commit();
    changeColor(tv_fragmenta);
  }

  @Override
  public void onClick(View v) {
    
    ft = fm.beginTransaction();
    switch (v.getId()) {
      case R.id.tv_fragmenta:
        changeFragment(ft,fgma);
        Log.i(TAG, "a is show");
        break;
      case R.id.tv_fragmentb:
        changeFragment(ft,fgmb);
        Log.i(TAG, "b is show");
        break;
      case R.id.tv_fragmentc:
        changeFragment(ft,fgmc);
        Log.i(TAG, "c is show");
        break; 

      default:
        break;
    }
    ft.commit();
    changeColor(v);
//    loggerVisibility();
  }

  void changeFragment(FragmentTransaction ft,Fragment fgm){
    hideAllandShow(ft,fgm);
//    removeAllandAdd(ft,fgm);
  }
  void hideAllandShow(FragmentTransaction ft,Fragment fgm){
    ft.hide(fgma);
    ft.hide(fgmb);
    ft.hide(fgmc);
    ft.show(fgm);
  };
  void removeAllandAdd( FragmentTransaction ft,Fragment fgm){
    ft.replace(R.id.fragmentContainer, fgm);
  }
  private void changeColor(View tv){
    tv_fragmenta.setBackgroundColor(Color.GRAY);
    tv_fragmentb.setBackgroundColor(Color.GRAY);
    tv_fragmentc.setBackgroundColor(Color.GRAY);
    tv.setBackgroundColor(Color.LTGRAY);
  }
  void loggerVisibility(){
    Log.i(TAG, "fgma visibility:"+fgma.mRootView.getVisibility());
    Log.i(TAG, "fgmb visibility:"+fgmb.mRootView.getVisibility());
    Log.i(TAG, "fgmc visibility:"+fgmc.mRootView.getVisibility());
    
  }
}
