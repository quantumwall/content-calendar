package org.quantum.contentcalendar.controller;

import java.util.List;

import org.quantum.contentcalendar.model.Content;
import org.quantum.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentRepository;

    public ContentController(ContentCollectionRepository contentRepository) {
	this.contentRepository = contentRepository;
    }

    @GetMapping
    public List<Content> getContents() {
	return contentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content getContent(@PathVariable Integer id) {
	return contentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Content content) {
	contentRepository.save(content);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Content content, @PathVariable Integer id) {
	contentRepository.findById(id).ifPresentOrElse(c -> contentRepository.save(content),
		() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
	if (!contentRepository.delete(id)) {
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
    }

}
