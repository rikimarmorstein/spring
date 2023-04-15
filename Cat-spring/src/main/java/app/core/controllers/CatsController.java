package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Cat;
import app.core.exception.CatsCustomException;
import app.core.services.CatService;

@RestController
@RequestMapping("/api/cats")
public class CatsController {
	@Autowired
	private CatService catService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cat addCat(@RequestBody Cat cat) {
		try {
			return catService.addCat(cat);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCat(@RequestBody Cat cat) throws CatsCustomException {
		catService.updateCat(cat);
	}

	@DeleteMapping("/{catId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCat(@PathVariable int catId) throws CatsCustomException {
		catService.deleteCat(catId);
	}

	@GetMapping("/getAllCats")
	public List<Cat> getAllCats() {
		try {
			return catService.getAllCats();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/getOneCat")
	public Cat getOneCat(int catId) throws CatsCustomException {
		try {
			return catService.getOneCat(catId);
		} catch (CatsCustomException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/nameAndWeight")
	public List<Cat> getCatsByNameAndWeight(String nameCat, double weight) throws CatsCustomException {
		if (weight < 0) {
			throw new CatsCustomException("Not putting on a proper weight");

		}
		try {
			return catService.getCatsByNameAndWeight(nameCat, weight);
		} catch (CatsCustomException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/ByWeight")
	public List<Cat> getCatsByNameOrWeight(String name, double weight) throws CatsCustomException {
		if (weight < 0) {
			throw new CatsCustomException("Not putting on a proper weight");
		}
		try {
			return catService.getCatsByNameOrWeight(name, weight);
		} catch (CatsCustomException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/ByWeightUp")
	public List<Cat> getAllCatsByWeightUp() {

		try {
			return catService.getAllCatsByWeightUp();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/ByWeightDown")
	public List<Cat> getAllCatsByWeightDown() {
		try {
			return catService.getAllCatsByWeightDown();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/CatsByTav")
	public List<Cat> getAllCatsByTav(@RequestParam String tav) {
		try {
			return catService.getAllCatsByTav(tav);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/WightCats")
	public double averageWightCats() {
		try {
			return catService.averageWightCats();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
