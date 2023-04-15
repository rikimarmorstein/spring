package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Cat;
import app.core.exception.CatsCustomException;
import app.core.repositories.CatRepository;

@Service
@Transactional
public class CatServiceImpl implements CatService {
	@Autowired
	private CatRepository catRepository;

	@Override
	public Cat addCat(Cat cat) {
		return catRepository.save(cat);
	}

	@Override
	public void updateCat(Cat cat) throws CatsCustomException {
		Cat catUpdate = catRepository.findById(cat.getId())
				.orElseThrow(() -> new CatsCustomException("id " + cat.getId() + " - not found"));
		catUpdate.setName(cat.getName());
		catUpdate.setWeight(cat.getWeight());
		catUpdate.setBirthday(cat.getBirthday());
		catUpdate.setToys(cat.getToys());
		catRepository.save(catUpdate);
	}

	@Override
	public void deleteCat(int catId) throws CatsCustomException {
		Cat cat = catRepository.findById(catId)
				.orElseThrow(() -> new CatsCustomException("id " + catId + " - not found"));
		catRepository.delete(cat);
	}

	@Override
	public List<Cat> getAllCats() {
		List<Cat> cats = catRepository.findAll();
		return cats;
	}

	@Override
	public Cat getOneCat(int catId) throws CatsCustomException {
		Cat cat = catRepository.findById(catId)
				.orElseThrow(() -> new CatsCustomException("id " + catId + " - not found"));
		return cat;
	}

	@Override
	public List<Cat> getCatsByNameAndWeight(String nameCat, double weight) throws CatsCustomException {
		List<Cat> cats = catRepository.findByNameAndWeight(nameCat, weight);
		return cats;
	}

	@Override
	public List<Cat> getCatsByNameOrWeight(String name, double weigth) throws CatsCustomException {
		List<Cat> cats = catRepository.findByNameOrWeight(name, weigth);
		return cats;
	}

	@Override
	public List<Cat> getAllCatsByWeightUp() {
		List<Cat> cats = catRepository.findAllByOrderByWeight();
		return cats;
	}

	@Override
	public List<Cat> getAllCatsByWeightDown() {
		List<Cat> cats = catRepository.findAllByOrderByWeightDesc();
		return cats;
	}

	@Override
	public List<Cat> getAllCatsByTav(String letter) throws CatsCustomException {
		List<Cat> cats = catRepository.findByNameStartingWith(letter);
		return cats;
	}

	@Override
	public double averageWightCats() {
		return catRepository.avgWeight();
	}

}
