package com.iflytek.voiceadsdemo;

import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYBannerAd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentA extends Fragment {
	private static final String TAG = "FragmentA";
	private int MaxBannerNum = 8;
	private LinearLayout[] layout_adsArray = new LinearLayout[MaxBannerNum];
	private IFLYBannerAd[] bannerViewArrayAd = new IFLYBannerAd[MaxBannerNum];
	private TextView mTextView;
	public View mRootView;
	private Fragment mFragment = this;
	private int[] layout_adsIdArray = { R.id.layout_adview, R.id.layout_adview2,
			R.id.layout_adview3, R.id.layout_adview4, R.id.layout_adview5,
			R.id.layout_adview6, R.id.layout_adview7, R.id.layout_adview8, };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "FragmentA onCreateView");
		mRootView = inflater.inflate(R.layout.fragmenta8, null);
		initFragment();
		return mRootView;
	}

	private void initFragment() {
		mTextView = ((TextView) mRootView.findViewById(R.id.txtView_tip));

		createMultiBannerAdsInMultiLayouts(3);
		// createBannerAd();// iflytekAd
		// createBannerAd();// iflytekAd
		// createTwoBannerAdInOneLayoutS();
		// createTwoBannerAdInOneLayoutT();

		mTextView.setText("requesting");
	}

	public void createBannerAd() {
		Log.i(TAG, "createBannerAd()");
		// 此广告位为Demo专用，广告的展示不产生费用
		// String adUnitId = "B6D9C742291F2511B485D6E2A9D4B03A";
		// 线上测试,安沃
		// String adUnitId = "F480573640153F838552B05F1681B8D6";
		// 线上测试,广点通
		// String adUnitId = "6E937B69435560106E054A71BE0F66F7";

		// String adUnitId = "DA4F1208D371511A52238BF46189286F";
		// String adUnitId = "DA4F1208D371511A52238BF46189286F";
		String adUnitId = "F88C5E0B7B75FE5BCEE1F78B62B84666";

		// 创建旗帜广告，传入广告位ID
		bannerViewArrayAd[0] = IFLYBannerAd.createBannerAd(this.getActivity(),
				adUnitId);
		// 设置请求的广告尺寸
		bannerViewArrayAd[0].setAdSize(IFLYAdSize.BANNER);
		// 请求广告，添加监听器
		bannerViewArrayAd[0].loadAd(mAdListener);
		// Log.i(TAG, ((Object) bannerViewArrayAd[0]).toString());
		// 将广告添加到布局
		layout_adsArray[0] = (LinearLayout) mRootView
				.findViewById(layout_adsIdArray[0]);
		layout_adsArray[0].removeAllViews();
		layout_adsArray[0].addView(bannerViewArrayAd[0]);
	}

	public void createMultiBannerAdsInMultiLayouts(int num) {
		if (num > MaxBannerNum - 1) {
			Toast.makeText(this.getActivity(), "bannerNum > MaxBannerNum(8)",
					Toast.LENGTH_SHORT).show();
			return;
		}
		Log.i(TAG, "createMultiBannerAdInTwoLayout()");
		// String adUnitId = "F88C5E0B7B75FE5BCEE1F78B62B84666";
		String adUnitId = "8FCA7E5106A3DB7DBC97B3B357E8A57F";
		for (int i = 0; i < num; i++) {
			bannerViewArrayAd[i] = IFLYBannerAd.createBannerAd(
					this.getActivity(), adUnitId);
			bannerViewArrayAd[i].setAdSize(IFLYAdSize.BANNER);
			bannerViewArrayAd[i].loadAd(mAdListenerArray[i]);
			layout_adsArray[i] = (LinearLayout) mRootView
					.findViewById(layout_adsIdArray[i]);
			layout_adsArray[i].removeAllViews();
			layout_adsArray[i].addView(bannerViewArrayAd[i]);
		}
	}

	// 同一个Layout中轮流创建两个banner
	public void createTwoBannerAdInOneLayoutS() {
		Log.i(TAG, "createTwoBannerAdInOneLayout()");
		String adUnitId = "DA4F1208D371511A52238BF46189286F";
		layout_adsArray[0] = (LinearLayout) mRootView
				.findViewById(R.id.layout_adview);
		layout_adsArray[0].removeAllViews();

		for (int i = 0; i < 2; i++) {
			bannerViewArrayAd[i] = IFLYBannerAd.createBannerAd(
					this.getActivity(), adUnitId);
			bannerViewArrayAd[i].setAdSize(IFLYAdSize.BANNER);
			bannerViewArrayAd[i].loadAd(mAdListenerArray[i]);
			layout_adsArray[0].addView(bannerViewArrayAd[i]);
		}
	}

	// 同一个Layout中一起创建两个banner
	public void createTwoBannerAdInOneLayoutT() {
		Log.i(TAG, "createTwoBannerAdInOneLayout()");
		String adUnitId = "DA4F1208D371511A52238BF46189286F";
		layout_adsArray[0] = (LinearLayout) mRootView
				.findViewById(R.id.layout_adview);
		layout_adsArray[0].removeAllViews();
		bannerViewArrayAd[0] = IFLYBannerAd.createBannerAd(this.getActivity(),
				adUnitId);
		bannerViewArrayAd[1] = IFLYBannerAd.createBannerAd(this.getActivity(),
				adUnitId);
		bannerViewArrayAd[0].setAdSize(IFLYAdSize.BANNER);
		bannerViewArrayAd[1].setAdSize(IFLYAdSize.BANNER);
		bannerViewArrayAd[0].loadAd(mAdListenerArray[0]);
		bannerViewArrayAd[1].loadAd(mAdListenerArray[1]);
		layout_adsArray[0].addView(bannerViewArrayAd[0]);
		layout_adsArray[0].addView(bannerViewArrayAd[1]);
	}

	// 生命周期
	// @Override
	// public void onResume() {
	// super.onResume();
	// // initBanner();
	// // createBannerAd();// iflytekAd
	// // create8BannerAdIn8Layout(1);
	// Log.i("AD_DEMO", "FragmentA onResume");
	//
	// }
	// @Override
	// public void onPause() {
	// super.onPause();
	// Log.i("AD_DEMO", "FragmentA onPause");
	// }
	// @Override
	// public void onSaveInstanceState(Bundle outState) {
	// super.onSaveInstanceState(outState);
	// Log.i("AD_DEMO", "FragmentA onSaveInstanceState");
	// }
	//
	// @Override
	// public void onHiddenChanged(boolean hidden) {
	// super.onHiddenChanged(hidden);
	// Log.i("AD_DEMO", "FragmentA onHiddenChanged");
	// }
	//
	//
	// @Override
	// public void onStop() {
	// super.onStop();
	// Log.i("AD_DEMO", "FragmentA onStop");
	// }
	// @Override
	// public void onDestroyView() {
	// super.onDestroyView();
	// Log.i("AD_DEMO", "FragmentA onDestroyView");
	// }
	// @Override
	// public void onDestroy() {
	// super.onDestroy();
	// Log.i("AD_DEMO", "FragmentA onDestroy");
	// }

	// 以下定义8个IFLYAdListener
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
	IFLYAdListener[] mAdListenerArray = { mAdListener, mAdListener2,
			mAdListener3, mAdListener4, mAdListener5, mAdListener6,
			mAdListener7, mAdListener8,

	};
}
