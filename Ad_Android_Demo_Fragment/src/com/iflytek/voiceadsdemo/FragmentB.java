/*
 * FragmentA.java
 * classes : com.iflytek.voiceadsdemo.FragmentA
 * @author 周众
 * V 1.0.0
 * Create at 2015-9-8 下午4:25:53
 */
package com.iflytek.voiceadsdemo;

import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.IFLYAdListener;
import com.iflytek.voiceads.IFLYAdSize;
import com.iflytek.voiceads.IFLYBannerAd;

import android.R.integer;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class FragmentB extends Fragment {
  private static final String TAG = "FragmentA";
  private LinearLayout layout_ads;
  private LinearLayout layout_ads2;
//  private LinearLayout layout_ads3;
//  private LinearLayout layout_ads4;
//  private LinearLayout layout_ads5;
//  private LinearLayout layout_ads6;
//  private LinearLayout layout_ads7;
//  private LinearLayout layout_ads8;
  private IFLYBannerAd bannerView;
  private IFLYBannerAd bannerView2;
//  private IFLYBannerAd bannerView3;
//  private IFLYBannerAd bannerView4;
//  private IFLYBannerAd bannerView5;
//  private IFLYBannerAd bannerView6;
//  private IFLYBannerAd bannerView7;
//  private IFLYBannerAd bannerView8;

  int bannerViewSize = 8;
  private LinearLayout[] layout_adsArray = new LinearLayout[bannerViewSize];
  IFLYBannerAd[] bannerViewArrayAd = new IFLYBannerAd[bannerViewSize];

  private TextView mTextView;
  public View mRootView;
  Fragment mFragment = this;

  // For GDT
  ViewGroup bannerContainer;
  ViewGroup bannerContainer2;
  ViewGroup[] bannerContainerArray = new ViewGroup[bannerViewSize];
  int[] layout_adsIdArray = { R.id.layout_adview, R.id.layout_adview2, R.id.layout_adview3, R.id.layout_adview4,
      R.id.layout_adview5, R.id.layout_adview6, R.id.layout_adview7, R.id.layout_adview8, };

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    Log.i(TAG, "FragmentA onCreateView");
    mRootView = inflater.inflate(R.layout.fragmenta8, null);
    initFragment();
    return mRootView;
  }

  private void initFragment() {
    mTextView = ((TextView) mRootView.findViewById(R.id.txtView_tip));
    // createBannerAd();// iflytekAd
    // createTwoBannerAdInOneLayout();
    // createTwoBannerAdInTwoLayout();
    // initBanner();//GDTad
    // initTwoBannerS();
//    init8BannerS();
//     create8BannerAdIn8Layout();
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
    String adUnitId = "DA4F1208D371511A52238BF46189286F";
    // 创建旗帜广告，传入广告位ID
    bannerView = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // 设置请求的广告尺寸
    bannerView.setAdSize(IFLYAdSize.BANNER);
    // 请求广告，添加监听器
    bannerView.loadAd(mAdListener);
    Log.i(TAG, ((Object) bannerView).toString());
    // 将广告添加到布局
    layout_ads = (LinearLayout) mRootView.findViewById(R.id.layout_adview);
    layout_ads.removeAllViews();
    layout_ads.addView(bannerView);

  }

  // @Override
  // public void onActivityCreated(Bundle savedInstanceState) {
  // super.onActivityCreated(savedInstanceState);
  // Log.i("AD_DEMO", "FragmentA onActivityCreated");
  // }
  // @Override
  // public void onStart() {
  // super.onStart();
  // Log.i(TAG, "onStart");
  // }
  //
  //
  // @Override
  // public void onResume() {
  // super.onResume();
  // // initBanner();
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

  public void createTwoBannerAdInOneLayout() {
    Log.i(TAG, "createTwoBannerAdInOneLayout()");
    String adUnitId = "DA4F1208D371511A52238BF46189286F";
    bannerView = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    bannerView2 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    bannerView.setAdSize(IFLYAdSize.BANNER);
    bannerView2.setAdSize(IFLYAdSize.BANNER);
    bannerView.loadAd(mAdListener);
    bannerView2.loadAd(mAdListener);
    layout_ads = (LinearLayout) mRootView.findViewById(R.id.layout_adview);
    layout_ads.removeAllViews();
    layout_ads.addView(bannerView);
    layout_ads.addView(bannerView2);

  }

  public void createTwoBannerAdInTwoLayout() {
    Log.i(TAG, "createTwoBannerAdInTwoLayout()");
    String adUnitId = "DA4F1208D371511A52238BF46189286F";
    bannerView = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);

    Log.i(TAG, "bannerView=" + ((Object) bannerView).toString());

    bannerView2 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);

    Log.i(TAG, "bannerView=" + ((Object) bannerView).toString());
    Log.i(TAG, "bannerView2=" + ((Object) bannerView2).toString());

    bannerView.setAdSize(IFLYAdSize.BANNER);
    bannerView2.setAdSize(IFLYAdSize.BANNER);
    bannerView.loadAd(mAdListener);
    bannerView2.loadAd(mAdListener2);
    layout_ads = (LinearLayout) mRootView.findViewById(R.id.layout_adview);
    layout_ads.removeAllViews();
    layout_ads.addView(bannerView);
    layout_ads2 = (LinearLayout) mRootView.findViewById(R.id.layout_adview2);
    layout_ads2.removeAllViews();
    layout_ads2.addView(bannerView2);

  }

  public void create8BannerAdIn8Layout() {
    Log.i(TAG, "createTwoBannerAdInTwoLayout()");
    String adUnitId = "DA4F1208D371511A52238BF46189286F";
    for (int i = 0; i < bannerViewSize; i++) {

      bannerViewArrayAd[i] = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
      bannerViewArrayAd[i].setAdSize(IFLYAdSize.BANNER);
      bannerViewArrayAd[i].loadAd(mAdListenerArray[i]);

      layout_adsArray[i] = (LinearLayout) mRootView.findViewById(layout_adsIdArray[i]);
      layout_adsArray[i].removeAllViews();
      layout_adsArray[i].addView(bannerViewArrayAd[i]);
    }
    // bannerView2 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // bannerView3 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // bannerView4 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // bannerView5 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // bannerView6 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // bannerView7 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);
    // bannerView8 = IFLYBannerAd.createBannerAd(this.getActivity(), adUnitId);

    // bannerView.setAdSize(IFLYAdSize.BANNER);
    // bannerView2.setAdSize(IFLYAdSize.BANNER);
    // bannerView3.setAdSize(IFLYAdSize.BANNER);
    // bannerView4.setAdSize(IFLYAdSize.BANNER);
    // bannerView5.setAdSize(IFLYAdSize.BANNER);
    // bannerView6.setAdSize(IFLYAdSize.BANNER);
    // bannerView7.setAdSize(IFLYAdSize.BANNER);
    // bannerView8.setAdSize(IFLYAdSize.BANNER);

    // bannerView.loadAd(mAdListener);
    // bannerView2.loadAd(mAdListener2);
    // bannerView3.loadAd(mAdListener3);
    // bannerView4.loadAd(mAdListener4);
    // bannerView5.loadAd(mAdListener5);
    // bannerView6.loadAd(mAdListener6);
    // bannerView7.loadAd(mAdListener7);
    // bannerView8.loadAd(mAdListener8);

    // layout_ads = (LinearLayout) mRootView.findViewById(R.id.layout_adview);
    // layout_ads.removeAllViews();
    // layout_ads.addView(bannerView);
    // layout_ads2 = (LinearLayout) mRootView.findViewById(R.id.layout_adview2);
    // layout_ads2.removeAllViews();
    // layout_ads2.addView(bannerView2);
    //
    // layout_ads3 = (LinearLayout) mRootView.findViewById(R.id.layout_adview3);
    // layout_ads3.removeAllViews();
    // layout_ads3.addView(bannerView3);
    // layout_ads4 = (LinearLayout) mRootView.findViewById(R.id.layout_adview4);
    // layout_ads4.removeAllViews();
    // layout_ads4.addView(bannerView4);
    // layout_ads5 = (LinearLayout) mRootView.findViewById(R.id.layout_adview5);
    // layout_ads5.removeAllViews();
    // layout_ads5.addView(bannerView5);
    // layout_ads6 = (LinearLayout) mRootView.findViewById(R.id.layout_adview6);
    // layout_ads6.removeAllViews();
    // layout_ads6.addView(bannerView6);
    // layout_ads7 = (LinearLayout) mRootView.findViewById(R.id.layout_adview7);
    // layout_ads7.removeAllViews();
    // layout_ads7.addView(bannerView7);
    // layout_ads8 = (LinearLayout) mRootView.findViewById(R.id.layout_adview8);
    // layout_ads8.removeAllViews();
    // layout_ads8.addView(bannerView8);

  }

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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
      mTextView.setText("failed:" + error.getErrorCode() + "," + error.getErrorDescription());
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
  IFLYAdListener[] mAdListenerArray = { mAdListener, mAdListener2, mAdListener3, mAdListener4, mAdListener5,
      mAdListener6, mAdListener7, mAdListener8,

  };
}
