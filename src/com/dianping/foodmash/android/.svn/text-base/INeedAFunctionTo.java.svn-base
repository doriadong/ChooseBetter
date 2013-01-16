package com.dianping.foodmash.android;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class INeedAFunctionTo {
	@SuppressWarnings("unused")
	public void SavePic(Bitmap bitmap,String photoName) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ByteArrayOutputStream baos = null; // 字节数组输出流
		try {
			baos = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
			byte[] byteArray = baos.toByteArray();// 字节数组输出流转换成字节数组
			String saveDir = "/sdcard/myImage";
			File dir = new File(saveDir); 
			if (!dir.exists()) {
				dir.mkdir(); // 创建文件夹
			}
			File file = new File(saveDir + "/" + photoName);
			file.delete();
			if (!file.exists()) {
				file.createNewFile();// 创建文件
			}
			// 将字节数组写入到刚创建的图片文件中
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(byteArray);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public HttpEntity getResponse(String uri, FileBody fileBody,StringBody stringBody){
		HttpClient httpclient = new DefaultHttpClient();
		HttpEntity resEntity=null;
		 try {
	            HttpPost httppost = new HttpPost("http://192.168.67.75:8080"+uri);
	            MultipartEntity reqEntity = new MultipartEntity();
	            reqEntity.addPart("fileBody", fileBody);
	            reqEntity.addPart("stringBody", stringBody);
	            httppost.setEntity(reqEntity);
	            System.out.println("executing request " + httppost.getRequestLine());
	            HttpResponse response = httpclient.execute(httppost);
	            resEntity = response.getEntity();
	            return resEntity;
	        } catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
	            try {
	            	httpclient.getConnectionManager().shutdown(); 
	            	} 
	            catch (Exception ignore) {
	            	 System.out.println("error");
	            }
	        }
		 return null;
	}
	
	public HttpEntity getResponseByGet(String uri){
		 HttpGet httpRequest = new HttpGet(uri); 
		 HttpEntity resEntity=null;
	       HttpResponse httpResponse;
		try {
			httpResponse = new DefaultHttpClient().execute(httpRequest);
			if(httpResponse.getStatusLine().getStatusCode() == 200)  
		       {
		    	   resEntity=httpResponse.getEntity();
		    	   InputStream inputStream=resEntity.getContent();
		    	   
		    	   return resEntity;
		       }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static Drawable loadImageFromUrl(String url) {
        URL mURL;
        InputStream i = null;
        try {
            mURL = new URL(url);
            i = (InputStream) mURL.getContent();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable drawable = Drawable.createFromStream(i, "src");
        return drawable;
    }
	
}