package org.quantum.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("cc")
public record CalendarProperties(String message, String about) {

}
