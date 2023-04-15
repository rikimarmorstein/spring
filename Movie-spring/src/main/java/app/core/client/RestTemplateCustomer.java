package app.core.client;

import org.springframework.web.client.RestTemplate;

import app.core.entities.Rate;
import app.core.entities.Rating;

public class RestTemplateCustomer {

	public static void main(String[] args) {

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/api";
		try {

			Rate rate = Rate.builder().name("very-good").rating(Rating.FIVE_STARS).comment("very").build();
			Rate creatRate = rt.postForObject(url + "/3", rate, Rate.class);
			System.out.println(creatRate);

			Rate rateUpdate = Rate.builder().name("very-very-good").rating(Rating.FIVE_STARS).comment("very").build();
			rt.put(url + "/3/35", rateUpdate, Rate.class);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
