package text.tao.com.myapplication.push.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPUtils {

	public static String get(String url) throws IOException {
		assert url != null && url.trim().length() != 0;

		HttpURLConnection huc = null;
		try {
			huc = getHttpURLConnection(url, "GET");
			InputStream inputStream = huc.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			StringBuilder result = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				result.append(line);
				result.append("\r\n");
			}

			return result.toString();
		}catch (Exception e){
			return "";
		} finally{
			if (huc != null) {
				huc.disconnect();
			}
		}
	}

	public static String post(String url, String data) throws IOException {
		assert url != null && url.trim().length() != 0;

		HttpURLConnection huc = null;
		try {
			huc = getHttpURLConnection(url, "POST");

			huc.setDoOutput(true);
			huc.setDoInput(true);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(huc.getOutputStream(), "UTF-8"));
			writer.write(data);

			BufferedReader reader = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			StringBuilder result = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				result.append(line);
				result.append("\r\n");
			}

			return result.toString();
		} finally {
			if (huc != null) {
				huc.disconnect();
			}
		}
	}

	private static HttpURLConnection getHttpURLConnection(String url, String method) throws IOException {
		HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
		//设置请求方式
		huc.setRequestMethod(method);
		//是否缓存
		huc.setUseCaches(false);
		//设置内容类型为可序列化的java对象
		huc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		huc.setRequestProperty("Charset", "UTF-8");

		return huc;
	}

//	public static void main(String[] args) throws IOException {
//		System.err.println(get("http://114.112.93.13/server/get?key=Terry-Mao&proto=2"));
//	}
}
