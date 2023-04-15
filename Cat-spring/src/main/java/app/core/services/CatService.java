package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import app.core.entities.Cat;
import app.core.exception.CatsCustomException;

@Service
@Transactional
public interface CatService {

	Cat addCat(Cat cat);

	void updateCat(Cat cat) throws CatsCustomException;

	void deleteCat(int catId) throws CatsCustomException;

	List<Cat> getAllCats();

	Cat getOneCat(int catId) throws CatsCustomException;

	List<Cat> getCatsByNameAndWeight(String nameCat, double weight) throws CatsCustomException;

	List<Cat> getCatsByNameOrWeight(String name, double weigth) throws CatsCustomException;

	List<Cat> getAllCatsByWeightUp();

	List<Cat> getAllCatsByWeightDown();

	List<Cat> getAllCatsByTav(String tav) throws CatsCustomException;

	double averageWightCats();

}
