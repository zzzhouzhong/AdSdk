package com.iflytek.voiceadsdemo;

import java.util.List;

import com.androidquery.AQuery;
import com.iflytek.voiceads.AdError;
import com.iflytek.voiceads.AdKeys;
import com.iflytek.voiceads.IFLYNativeAd;
import com.iflytek.voiceads.IFLYNativeListener;
import com.iflytek.voiceads.NativeADDataRef;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class NativeAdActivity extends Activity implements IFLYNativeListener{
	private IFLYNativeAd nativeAd;
	private List<NativeADDataRef> mlist;
	protected AQuery $;
	private NativeADDataRef adItem;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_native);
//		setContentView(R.layout.activity_native_scroll);

		mTextView = (TextView)findViewById(R.id.textView1);
		
		$ = new AQuery(this);
		$.id(R.id.loadNative).clicked(this, "loadAD");
		$.id(R.id.showNative).clicked(this, "showAD").enabled(false);
		
	}
// 图片墙        	6BCAF26BF03C1114406A46E952315764

//动态消息  	83BB0DBE1EE2C187E5A30D95D6A1800F
//内容流   	A6F46B5B67F1A0C3802F762D534B53AE
	
	public void loadAD() {
		if (nativeAd == null) {
			nativeAd = new IFLYNativeAd(this,
					"402EAB8C70AF8F7E396AA559B8029AF5", this);  // 视频 976FCD4AABE9A8436B7255B18E8A605F  89C176237D9DCE70138AE64287B799B8  
		}
		//ADAC57776D8662325429D15FF779E59A  //广升
		
		//6BCAF26BF03C1114406A46E952315764
		
		mTextView.setText("requesting");
		int count = 1; // 一次拉取的广告条数：范围1-30
		nativeAd.setParameter(AdKeys.DEBUG_MODE, "true");
		
		nativeAd.loadAd(count);
	}

	public void showAD() {
		$.id(R.id.img_logo).image((String) adItem.getIcon(), false, true);
		$.id(R.id.img_poster).image(adItem.getImage(), false, true);
		$.id(R.id.text_name).text((String) adItem.getTitle());
		$.id(R.id.text_desc).text((String) adItem.getSubTitle());
		adItem.onExposured(this.findViewById(R.id.nativeADContainer));
		$.id(R.id.btn_download).clicked(new OnClickListener() {
			@Override
			public void onClick(View view) {
				adItem.onClicked(view);
			}
		});
	}

	@Override
	public void onAdFailed(AdError error) {
		// TODO Auto-generated method stub
		Log.d("onAdFailed", error.getErrorDescription());
		mTextView.setText(""+error.getErrorCode());
	}

	@Override
	public void onADLoaded(List<NativeADDataRef> lst) {
//		Log.d("onADLoaded", lst + ""+Thread.currentThread().toString());
		mTextView.setText("success");
	    if (lst.size() > 0) {
	
	        adItem = lst.get(0);
	        $.id(R.id.showNative).enabled(true);
	        Toast.makeText(this, "原生广告加载成功", Toast.LENGTH_LONG).show();
//	        showAD();
	        
	      } else {
	        Log.i("AD_DEMO", "NOADReturn");
	      }
	}
}
