package no.hvl.dat110.aciotdevice.client;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestClient {

	public RestClient() {
		// TODO Auto-generated constructor stub
	}

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	private static String logpath = "/accessdevice/log";

	public void doPostAccessEntry(String message) {

		// TODO: implement a HTTP POST on the service to post the message
		RequestBody body = RequestBody.create(JSON, message);
		Request req = new Request.Builder().url("http://localhost:8080" + logpath).post(body).build();
		OkHttpClient client = new OkHttpClient();
		
		try (Response response = client.newCall(req).execute()) {
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String codepath = "/accessdevice/code";

	public AccessCode doGetAccessCode() {
		Gson gson = new Gson();
		AccessCode code = null;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("http://localhost:8080" + codepath).get().build();
		try (Response response = client.newCall(request).execute()) {
			code = gson.fromJson(gson.toJson(response.body().string()), AccessCode.class);
			System.out.println(response.body().string());
		} catch (IOException e) {
			System.out.println("oh no");
			e.printStackTrace();
		}

		// TODO: implement a HTTP GET on the service to get current access code

		return code;
	}
}
