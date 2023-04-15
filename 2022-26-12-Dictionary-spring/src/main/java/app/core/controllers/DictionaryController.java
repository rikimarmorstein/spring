package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.EntryWord;
import app.core.entities.ExampleSentence;
import app.core.exceptions.DictionaryException;
import app.core.services.DictionaryService;

@RestController
@RequestMapping("/api/dictionary")
@CrossOrigin
public class DictionaryController {
	@Autowired
	private DictionaryService dictionary;

	@PostMapping
	public EntryWord addWordToDictionary(@RequestBody EntryWord entryWord) {
		try {
			return dictionary.addWordToDictionary(entryWord);
		} catch (DictionaryException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@GetMapping("/{entryWordId}")
	public EntryWord getEntryWordById(@PathVariable int entryWordId) {
		try {
			return dictionary.getEntryWordById(entryWordId);
		} catch (DictionaryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@GetMapping("/getEntryWord")
	public List<ExampleSentence> getExampleFromEntryWord(@RequestParam int entryWordId) {
		return dictionary.getExampleFromEntryWord(entryWordId);
	}

	@PutMapping
	public EntryWord updateEntryWord(@RequestBody EntryWord entryWord) {
		try {
			return dictionary.updateEntryWord(entryWord);
		} catch (DictionaryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@DeleteMapping("/{entryWordId}")
	public void deleteEntryWordById(@PathVariable int entryWordId) {
		try {
			dictionary.deleteEntryWordById(entryWordId);
		} catch (DictionaryException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
