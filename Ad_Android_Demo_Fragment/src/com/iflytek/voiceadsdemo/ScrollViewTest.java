package com.iflytek.voiceadsdemo;

import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYBannerAd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollViewTest extends Activity {
	private static final String TAG = "ScrollViewTest";
	private TextView mTextView;
	private ScrollView scrollView;
	private int MaxBannerNum = 8;
	private LinearLayout[] layout_adsArray = new LinearLayout[MaxBannerNum];
	private IFLYBannerAd[] bannerViewArrayAd = new IFLYBannerAd[MaxBannerNum];
	private int[] layout_adsIdArray = { R.id.layout_adview, R.id.layout_adview2,
			R.id.layout_adview3, R.id.layout_adview4, R.id.layout_adview5,
			R.id.layout_adview6, R.id.layout_adview7, R.id.layout_adview8, };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmenta8);
		mTextView = ((TextView) findViewById(R.id.txtView_tip));
		scrollView = (ScrollView) findViewById(R.id.scrollView);
		
		createBannerAd();
		// createMultiBannerAdsInMultiLayouts(1);
		
		mTextView.setText("requesting");
	}

	public void createMultiBannerAdsInMultiLayouts(int num) {
		if(num>MaxBannerNum-1){
			Toast.makeText(this, "bannerNum > MaxBannerNum(8)", Toast.LENGTH_SHORT).show();
			return;
		}
		Log.i(TAG, num+"createMultiBannerAdInTwoLayout()");
		String adUnitId = "DA4F1208D371511A52238BF46189286F";
		for (int i = 0; i < num; i++) {
			bannerViewArrayAd[i] = IFLYBannerAd.createBannerAd(this, adUnitId);
			bannerViewArrayAd[i].setAdSize(IFLYAdSize.BANNER);
			bannerViewArrayAd[i].loadAd(mAdListenerArray[i]);
			layout_adsArray[i] = (LinearLayout) findViewById(layout_adsIdArray[i]);
			layout_adsArray[i].removeAllViews();
			layout_adsArray[i].addView(bannerViewArrayAd[i]);
		}
	}

	public void createBannerAd() {
		// 此广告位为Demo专用，广告的展示不产生费用
		// String adUnitId = "B6D9C742291F2511B485D6E2A9D4B03A";
		// 线上测试,安沃
		// String adUnitId = "F480573640153F838552B05F1681B8D6";
		// 线上测试,广点通
		// String adUnitId = "6E937B69435560106E054A71BE0F66F7";

		// String adUnitId = "DA4F1208D371511A52238BF46189286F";
		String adUnitId = "8FCA7E5106A3DB7DBC97B3B357E8A57F";

		// 创建旗帜广告，传入广告位ID
		bannerViewArrayAd[0] = IFLYBannerAd.createBannerAd(this, adUnitId);
		// bannerView2 = IFLYBannerAd.createBannerAd(this, adUnitId);
		// 设置请求的广告尺寸
		bannerViewArrayAd[0].setAdSize(IFLYAdSize.BANNER);
		// 请求广告，添加监听器
		bannerViewArrayAd[0].loadAd(mAdListener);
		// 将广告添加到布局
		layout_adsArray[0] = (LinearLayout) findViewById(layout_adsIdArray[0]);
		layout_adsArray[0].removeAllViews();
		layout_adsArray[0].addView(bannerViewArrayAd[0]);
	}
	
//	以下定义8个IFLYAdListener
	
	IFLYAdListener mAdListener = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[0].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener2 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[1].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener3 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[2].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener4 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[3].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener5 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[4].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener6 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[5].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener7 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[6].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	IFLYAdListener mAdListener8 = new IFLYAdListener() {

		/**
		 * 广告请求成功
		 */
		@Override
		public void onAdReceive() {
			// 展示广告
			bannerViewArrayAd[7].showAd();

			mTextView.setText("success");
			Log.d(TAG, "onAdReceive");
		}

		/**
		 * 广告请求失败
		 */
		@Override
		public void onAdFailed(AdError error) {
			mTextView.setText("failed:" + error.getErrorCode() + ","
					+ error.getErrorDescription());
			Log.d(TAG, "onAdFailed");
			// Log.d("Ad_Android_Demo", "onAdFailed");
		}

		/**
		 * 广告被点击
		 */
		@Override
		public void onAdClick() {
			mTextView.setText("ad click");
			Log.d(TAG, "onAdClick");
		}

		/**
		 * 广告被关闭
		 */
		@Override
		public void onAdClose() {
			mTextView.setText("ad close");
			Log.d(TAG, "onAdClose");
		}

		@Override
		public void onAdExposure() {
		}
	};
	private IFLYAdListener[] mAdListenerArray = { mAdListener, mAdListener2,
			mAdListener3, mAdListener4, mAdListener5, mAdListener6,
			mAdListener7, mAdListener8,
	};

}
