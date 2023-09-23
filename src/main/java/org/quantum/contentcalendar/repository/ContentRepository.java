package org.quantum.contentcalendar.repository;

import java.util.List;

import org.quantum.contentcalendar.model.Content;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    @Query("""
    	SELECT * FROM content
    	WHERE title LIKE :title
    	""")
    List<Content> findByTitle(@Param("title") String title);
}
