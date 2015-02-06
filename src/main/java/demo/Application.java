package demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

import be.admb.entities.Game;
import be.admb.entities.Team;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		String datum = formatter.format(cal.getTime());
		InetSocketAddress adress = new InetSocketAddress("proxy.kamodata.be", 8080);
		Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, adress);
		URI url = new URI("http://data.nba.com/json/cms/noseason/scoreboard/" + datum + "/games.json");
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setProxy(proxy);
		ClientHttpRequest request = factory.createRequest(url, HttpMethod.GET);
		ClientHttpResponse response = request.execute();
		if (response.getStatusCode() == HttpStatus.OK) {
			InputStream input = response.getBody();
			String myString = IOUtils.toString(input, "UTF-8");
			String[] temp = myString.split("\"game\":\\[");
			createGames(temp[1]);
		}
		SpringApplication.run(Application.class, args);
	}

	private static void createGames(String line) {
		String[] lijnen = line.split(",");
		List<Game> games = new ArrayList<Game>();
		Game game = new Game();
		long teller = 0;
		for (String lijn : lijnen) {
			if (lijn.contains("\"id\"")) {
				if (lijn.contains("visitor")) {
					game.setVisitors(createTeam(lijnen, teller));
				} else if (lijn.contains("home")) {
					game.setHome(createTeam(lijnen, teller));
				} else {
					if (game.getVisitors() != null) {
						games.add(game);
						game = new Game();
					}
					game.setId(Long.parseLong(lijn.split("\"")[3]));
				}
			}
			teller++;
		}
		games.add(game);
		for (Game gamet : games) {
			System.err.println(gamet.toString());
		}
	}

	private static Team createTeam(String[] lijnen, long teller) {
		Team team = new Team();
		String id = lijnen[(int) teller].split("\"")[5];
		team.setId(Long.parseLong(id));
		String city = lijnen[(int) teller + 2].split("\"")[3];
		team.setCity(city);
		String nickname = lijnen[(int) teller + 4].split("\"")[3];
		team.setNickname(nickname);
		String score = lijnen[(int) teller + 7];
		int scores = 0;
		if (!score.contains("\"\"")) {
			scores = Integer.parseInt(score.split("\"")[3]);
		}
		team.setScore(scores);
		return team;
	}
}
