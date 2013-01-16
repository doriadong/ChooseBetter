package com.dianping.foodmash.android;

import com.dianping.ChooseBetter.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ChooseBetterActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	ImageView image1;
	ImageView image2;
	private Button addBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        image1 = (ImageView) findViewById(R.id.imageView1);
        image2=(ImageView) findViewById(R.id.imageView2);
        addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
        String picInfoAndWinnerInfo=getIntent().getStringExtra("picInfoAndWinnerInfo");
        String pic1=picInfoAndWinnerInfo.split("@@")[0];
        String pic2=picInfoAndWinnerInfo.split("@@")[1];
        String bingo=picInfoAndWinnerInfo.split("@@")[2];
        Bitmap bmp=null;
		//bmp = BitmapFactory.decodeByteArray(arr, 0, arr.length);//arr十六进制数据
		image1.setImageBitmap(bmp);
        
    }
	
	public void onClick(View v) {
		 Intent intent = new Intent(ChooseBetterActivity.this, UploadPhotoActivity.class);
         this.startActivity(intent);
	}
}