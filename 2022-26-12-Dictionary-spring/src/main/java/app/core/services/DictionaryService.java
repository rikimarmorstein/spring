package app.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.EntryWord;
import app.core.entities.ExampleSentence;
import app.core.exceptions.DictionaryException;
import app.core.repositories.EntryWordRepository;
import app.core.repositories.ExampleSentenceRepository;

@Service
@Transactional
public class DictionaryService {
	@Autowired
	private EntryWordRepository entryWordRepository;
	@Autowired
	private ExampleSentenceRepository exampleSentenceRepository;

	public EntryWord addWordToDictionary(EntryWord entryWord) throws DictionaryException {
		if (this.entryWordRepository.existsById(entryWord.getId())) {
			throw new DictionaryException(
					"addWordToDictionary failed - word with id " + entryWord.getId() + " already exists");
		} else {
			return entryWordRepository.save(entryWord);
		}
	}

	public EntryWord getEntryWordById(int entryWordId) throws DictionaryException {
		return entryWordRepository.findById(entryWordId)
				.orElseThrow(() -> new DictionaryException("id " + entryWordId + " not found"));
	}

	public EntryWord updateEntryWord(EntryWord entryWord) throws DictionaryException {
		if (entryWordRepository.existsById(entryWord.getId())) {
			return entryWordRepository.save(entryWord);
		}
		throw new DictionaryException("updateEntryWord failed - id " + entryWord.getId() + " not found");
	}

	public void deleteEntryWordById(int entryWordId) throws DictionaryException {
		if (entryWordRepository.existsById(entryWordId)) {
			entryWordRepository.deleteById(entryWordId);
		} else {
			throw new DictionaryException("deleteEntryWordById failed- id " + entryWordId + " not found");
		}
	}

	public List<ExampleSentence> getExampleFromEntryWord(int entryWordId) {
		return exampleSentenceRepository.findByEntryWordId(entryWordId);
	}
}
