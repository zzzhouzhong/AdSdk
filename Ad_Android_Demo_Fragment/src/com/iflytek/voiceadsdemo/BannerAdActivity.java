package com.iflytek.voiceadsdemo;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iflytek.voiceads.*;

public class BannerAdActivity extends Activity {

	private LinearLayout layout_ads;
//	private IFLYBannerAd bannerView;
	private TextView mTextView;
	
	private IFLYBannerAd bannerView;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banner_layout);
		mTextView = ((TextView)findViewById(R.id.txtView_tip));
		
		createBannerAd();
		

	    mTextView.setText("requesting");
	    
	    
	    Button bb = (Button) findViewById(R.id.button1);
	    bb.setVisibility(View.GONE);
	    bb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createBannerAd();
			}
		});
	}
	
	public void createBannerAd() {
		//此广告位为Demo专用，广告的展示不产生费用
//	    String adUnitId = "B6D9C742291F2511B485D6E2A9D4B03A";
		//线上测试,安沃
//		String adUnitId = "F480573640153F838552B05F1681B8D6";
		//线上测试,广点通
//		String adUnitId = "6E937B69435560106E054A71BE0F66F7";
		
//		String adUnitId = "825B5A38C8A32B06F1F6DE16451777F7";
		String adUnitId = "8FCA7E5106A3DB7DBC97B3B357E8A57F";

		//创建旗帜广告，传入广告位ID
		bannerView = IFLYBannerAd.createBannerAd(this, adUnitId);
		//设置请求的广告尺寸
		bannerView.setAdSize(IFLYAdSize.BANNER);

		bannerView.setParameter(AdKeys.DEBUG_MODE, "true");
        bannerView.setParameter(AdKeys.DOWNLOAD_ALERT,"true");
        bannerView.setParameter(AdKeys.DEBUG_MODE, "true");
        
        
//        bannerView.setParameter(AdKeys.CUSTOM_BROSWER, "com.iflytek.voiceadsdemo.IFLYBrowser");

		//将广告添加到布局
		layout_ads = (LinearLayout)findViewById(R.id.layout_adview);
		layout_ads.removeAllViews();
		layout_ads.addView(bannerView);

        /* 请求广告，添加监听器 */
		bannerView.loadAd(mAdListener);
	}
	
	IFLYAdListener mAdListener = new IFLYAdListener(){

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			//展示广告
//		    bannerView.showAd();
		    
		    mTextView.setText("success");
		    Log.d("Ad_Android_Demo", "onAdReceive");
		}
		
		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:"+error.getErrorCode()+","+
						error.getErrorDescription());
		    Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
		    mTextView.setText("ad click");
		    Log.d("Ad_Android_Demo", "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
		    mTextView.setText("ad close");
		    Log.d("Ad_Android_Demo", "onAdClose");
		}

		@Override
		public void onAdExposure() {
			// TODO Auto-generated method stub
			
		}

		
    };
    
}
