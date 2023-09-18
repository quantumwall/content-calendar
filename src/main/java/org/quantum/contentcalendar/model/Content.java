package org.quantum.contentcalendar.model;

import java.time.LocalDateTime;

public record Content(Integer id, String title, String description, Status status, Type type, LocalDateTime dateCreated,
	LocalDateTime dateUpdated, String url) {

}
