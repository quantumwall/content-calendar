package org.quantum.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.quantum.contentcalendar.model.Content;
import org.quantum.contentcalendar.model.Status;
import org.quantum.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public List<Content> findAll() {
	return contentList;
    }

    public Optional<Content> findById(Integer id) {
	return contentList.stream().filter(c -> c.id().equals(id)).findAny();
    }
    
    public boolean save(Content content) {
	contentList.removeIf(c -> c.id().equals(content.id()));
	return contentList.add(content);
    }
    
    public boolean delete(Integer id) {
	return contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init() {
	contentList.addAll(List.of(
		new Content(1, "My first blog post", "my first blog post", Status.IDEA, Type.ARTICLE,
			LocalDateTime.now(), null, null),
		new Content(2, "My second blog post", "my second blog post", Status.COMPLETED, Type.COURSE,
			LocalDateTime.of(2023, 1, 9, 12, 0), LocalDateTime.now(), null)));
    }
}
