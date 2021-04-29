package no.hvl.dat110.aciotdevice.client;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class RestClient {

	public RestClient() {
		// TODO Auto-generated constructor stub
	}

	private static String logpath = "/accessdevice/log";

	public void doPostAccessEntry(String message) {

		// TODO: implement a HTTP POST on the service to post the message
		
	}
	
	private static String codepath = "/accessdevice/code";
	
	public AccessCode doGetAccessCode() {
       Gson gson = new Gson();
		AccessCode code = null;
		OkHttpClient client= new OkHttpClient();
		Request request = new Request.Builder()
				.url("http://localhost:8080"+codepath)
				.get()
				.build();
		try(Response response = client.newCall(request).execute()){
code = gson.fromJson(response.body(), Accesscode.class);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: implement a HTTP GET on the service to get current access code
		
		return code;
	}
}
