package org.quantum.contentcalendar.controller;

import java.util.List;

import org.quantum.contentcalendar.model.Content;
import org.quantum.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
