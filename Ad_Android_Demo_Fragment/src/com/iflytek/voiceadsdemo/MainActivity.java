package com.iflytek.voiceadsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btn_banner).setOnClickListener(this);
		findViewById(R.id.btn_interstitial).setOnClickListener(this);
		findViewById(R.id.btn_fullscreen).setOnClickListener(this);
//		findViewById(R.id.btn_native).setOnClickListener(this);
		findViewById(R.id.btn_fragment).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_banner:
			intent = new Intent(MainActivity.this, BannerAdActivity.class);
			break;
		case R.id.btn_interstitial:
			intent = new Intent(MainActivity.this, InterstitialAdActivity.class);
			break;
		case R.id.btn_fullscreen:
			intent = new Intent(MainActivity.this, FullScreenAdActivity.class);
			break;
//		case R.id.btn_native:
//			intent = new Intent(MainActivity.this, NativeAdActivity.class);
//			break;
	      case R.id.btn_fragment:
	          intent = new Intent(MainActivity.this, MyFragmentActivity.class);
//	          intent = new Intent(MainActivity.this, ScrollViewTest.class);
	          break;
		}
		if (null != intent) {
			startActivity(intent);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("Ad_Android_Demo", "onDestroy");
	}

}
