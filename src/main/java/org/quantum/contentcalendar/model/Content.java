package org.quantum.contentcalendar.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record Content(Integer id, @NotBlank String title, String description, Status status, Type type,
	LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {

}
