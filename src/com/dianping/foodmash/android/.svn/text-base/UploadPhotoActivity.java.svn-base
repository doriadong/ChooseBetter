package com.dianping.foodmash.android;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import com.dianping.ChooseBetter.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UploadPhotoActivity extends Activity implements OnClickListener {
	private ImageView imageToUpload;
	private Button confirmBtn;
	private String photoName;
	private EditText describeET;
	private INeedAFunctionTo iNeedAFunctionTo;
	
    /** Called when the activity is first created. */
    @SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_photo);
        imageToUpload= (ImageView) findViewById(R.id.imageToUpload);
        confirmBtn=(Button)findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(this);
        photoName=new DateFormat().format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINA)) + ".jpg";
        describeET=(EditText)findViewById(R.id.describeET);
        iNeedAFunctionTo=new INeedAFunctionTo();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }
    
	public void onClick(View arg0) {
		
		 FileBody fileBody = new FileBody(new File("/sdcard/myImage/"+photoName));
         StringBody stringBody = null;
         String uri="";
			try {
				String describe=describeET.getText().toString();
				stringBody = new StringBody(describe);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpEntity resEntity=iNeedAFunctionTo.getResponse(uri, fileBody, stringBody);
	}
	@Override
	   protected void onActivityResult(int requestCode, int resultCode,Intent data) {
	       // TODO Auto-generated method stub
	       if(resultCode!=RESULT_OK)
	           return;
	           Bitmap photo1 = data.getParcelableExtra("data");
	           if(photo1!=null){
	        	   imageToUpload.setImageBitmap(photo1);
	           }
	           iNeedAFunctionTo.SavePic(photo1,photoName);
	       }
	
	
	 
}