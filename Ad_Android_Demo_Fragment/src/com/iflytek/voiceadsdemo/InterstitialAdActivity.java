package com.iflytek.voiceadsdemo;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.AdKeys;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYInterstitialAd;

public class InterstitialAdActivity extends Activity implements View.OnClickListener {

	private IFLYInterstitialAd interstitialAd;
	private TextView mTextView;
    private Button destoryButton;
    private Button requestButton;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interstitial_layout);

		createInterstitialAd();
		
		mTextView = ((TextView)findViewById(R.id.txtView_tip));
    	mTextView.setText("requesting");

        destoryButton = (Button)findViewById(R.id.destory);
        destoryButton.setOnClickListener(this);
        destoryButton.setVisibility(View.GONE);

        requestButton = (Button)findViewById(R.id.request);
        requestButton.setOnClickListener(this);
        requestButton.setVisibility(View.GONE);

	}

	public void createInterstitialAd() {
		//此广告位为Demo专用，广告的展示不产生费用
//	    final String adUnitId = "3A2F00638A001B41D433E99A7AB7B8C5";
	    //线上测试，安沃
//	    final String adUnitId = "A8FC532E13ED4EDA1EEB144E177405BC";
	    //线上测试，广点通
//	    final String adUnitId = "12A711F3B9E65BFD7AA345AD11D868C2";
		
		//测试原生
//	    final String adUnitId = "594F85ED0D712D567D5FD927DE654F3B";
//	    final String adUnitId = "8F2D7DBCBE54A3B1E6898BE464F79CDA";
	    final String adUnitId = "3B6889CF8BFFA665E056F0E8FD90A21C";
	    
	    //创建插屏广告，传入广告位ID
		interstitialAd = IFLYInterstitialAd.createInterstitialAd(this, adUnitId);
	    //设置广告尺寸
	    interstitialAd.setAdSize(IFLYAdSize.INTERSTITIAL);
        interstitialAd.setParameter(AdKeys.DOWNLOAD_ALERT, "true");
//	    interstitialAd.setParameter(AdKeys.BACK_KEY_INTERCEPTION, "true");
//        interstitialAd.setParameter(AdKeys.BACK_KEY_ENABLE, "false");
        
        
//        interstitialAd.setParameter(AdKeys.BROSWER_TYEP, "com.iflytek.voiceadsdemo.IFLYBrowserTest");
        
//        interstitialAd.setParameter(AdKeys.BROSWER_TYEP, AdKeys.BROWSER_2345);
        
        
	    //请求广告，添加监听器
    	interstitialAd.loadAd(mAdListener);

	}
	
	IFLYAdListener mAdListener = new IFLYAdListener(){

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			//展示广告
	    	interstitialAd.showAd();
	    	request1111();
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
		    Log.d("Ad_Android_Demo", "onAdFailed:"+error.getErrorCode()+","+
					error.getErrorDescription());
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.destory:
             interstitialAd.destroyAd();
                break;
            case R.id.request:
//                createInterstitialAd();
                interstitialAd.loadAd(mAdListener);
                break;
        }
    }
    
    private void request1111(){
//    	interstitialAd.loadAd(mAdListener);
    	 Log.d("Ad_Android_Demo", "request1111");
    }
    
    
    
}
