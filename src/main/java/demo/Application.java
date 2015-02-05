package demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		InetSocketAddress adress = new InetSocketAddress("proxy.kamodata.be", 8080);
		Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, adress);
		URI url = new URI("http://data.nba.com/json/cms/noseason/scoreboard/20101229/games.json");
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setProxy(proxy);
		ClientHttpRequest request = factory.createRequest(url, HttpMethod.GET);
		ClientHttpResponse response = request.execute();
		if (response.getStatusCode() == HttpStatus.OK) {
			InputStream input = response.getBody();
			String myString = IOUtils.toString(input, "UTF-8");
			String[] temp = myString.split("[");
			System.err.println(temp.length);
		}
		SpringApplication.run(Application.class, args);
	}
}
