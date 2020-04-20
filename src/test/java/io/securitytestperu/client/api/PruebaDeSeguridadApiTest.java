package io.securitytestperu.client.api;

import io.securitytestperu.client.ApiClient;
import io.securitytestperu.client.ApiException;
import io.securitytestperu.client.api.PruebaDeSeguridadApi;
import io.securitytestperu.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;


public class PruebaDeSeguridadApiTest {

    private final PruebaDeSeguridadApi api = new PruebaDeSeguridadApi();
    private ApiClient apiClient;
    
    @Before()
    public void setUp() {
    	this.apiClient = api.getApiClient();
    	this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
				.readTimeout(30, TimeUnit.SECONDS)
				.addInterceptor(new SignerInterceptor())
				.build();
		apiClient.setHttpClient(okHttpClient);
    }

    @Test
    public void securityTestTest() throws ApiException {
        String xApiKey = "your_api_key";
        String body = "Esto es un mensaje de prueba";
        String response = api.securityTest(xApiKey, body);
        System.out.println(response);
    }
    
}
