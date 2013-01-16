package com.dianping.foodmash.android;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.StringBody;

import com.dianping.ChooseBetter.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.text.format.DateFormat;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {
    /** Called when the activity is first created. */
	
	private final int SPLASH_DISPLAY_LENGHT = 2500;
	private boolean flag_finished=false;
	private INeedAFunctionTo iNeedAFunctionTo;
	private String android_id;
	private String url1;
    private String url2;
    private String bingo="";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        iNeedAFunctionTo=new INeedAFunctionTo();
        android_id = Secure.getString(getBaseContext().getContentResolver(), Secure.ANDROID_ID);
        
        new Handler().post(new Runnable(){
            public void run() {
            	SharedPreferences userInfo = getSharedPreferences("user_info", 0);
            	String token=userInfo.getString("token", "");
            	if(token.equals("")){
            		token=new DateFormat().format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINA))+android_id;
            		userInfo.edit().putString("token", token).commit();
						String url="http://192.168.67.75:8080/foodmash/rest/image/start"+"?token="+token;
						HttpEntity httpEntity=iNeedAFunctionTo.getResponseByGet(url);
	            		if(httpEntity!=null){
	            			url1="";
	            			url2="";
	            			flag_finished=true;
	            		}
					
            		
            	}else{
						
						String url="http://192.168.67.75:8080/foodmash/rest/image/start"+"?token="+token;
						HttpEntity httpEntity=iNeedAFunctionTo.getResponseByGet(url);
	            		if(httpEntity!=null){
	            			if(true){//win
								bingo="bingo";
							}
	            			url1="";
	            			url2="";
	            			flag_finished=true;
	            		}
            	}
            }
           });
        
        new Handler().postDelayed(new Runnable(){
            public void run() {
            	while(flag_finished==false);
                Intent mainIntent = new Intent(WelcomeActivity.this, ChooseBetterActivity.class);
                mainIntent.putExtra("picInfoAndWinnerInfo", url1+"@@"+url2+"@@"+bingo);
                WelcomeActivity.this.startActivity(mainIntent);
                WelcomeActivity.this.finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
           }, SPLASH_DISPLAY_LENGHT);
    }
	
	
}