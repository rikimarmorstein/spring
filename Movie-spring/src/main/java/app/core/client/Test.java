package app.core.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import app.core.entities.Movie;
import app.core.entities.Rate;
import app.core.entities.Rating;
import app.core.repositories.MovieRepository;
import app.core.repositories.RateRepository;

//@Component
public class Test implements CommandLineRunner {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RateRepository rateRepository;

	@Override
	public void run(String... args) {

		List<Rate> rateaa = new ArrayList<>();
		List<Rate> ratebb = new ArrayList<>();
		Movie drama = new Movie(0, "drama", 2012, rateaa);
		Movie seret = new Movie(0, "seret", 2013, ratebb);
		rateaa.add(Rate.builder().name("a").rating(Rating.FIVE_STARS).comment("aaa").movie(drama).build());
		rateaa.add(Rate.builder().name("b").rating(Rating.THREE_STARS).comment("bbb").movie(drama).build());
		rateaa.add(Rate.builder().name("c").rating(Rating.FIVE_STARS).comment("sss").movie(drama).build());
		rateaa.add(Rate.builder().name("d").rating(Rating.TWO_STARS).comment("ddd").movie(drama).build());

		ratebb.add(Rate.builder().name("r").rating(Rating.FIVE_STARS).comment("fsd").movie(seret).build());
		ratebb.add(Rate.builder().name("d").rating(Rating.TWO_STARS).comment("fds").movie(seret).build());
		ratebb.add(Rate.builder().name("ss").rating(Rating.FIVE_STARS).comment("d").movie(seret).build());
		ratebb.add(Rate.builder().name("aa").rating(Rating.THREE_STARS).comment("cc").movie(seret).build());
		movieRepository.save(drama);
		movieRepository.save(seret);
	}

}
