package org.quantum.contentcalendar.controller;

import org.quantum.contentcalendar.config.CalendarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    private final CalendarProperties properties;

    public HomeController(CalendarProperties properties) {
	this.properties = properties;
    }

    @GetMapping
    public CalendarProperties home() {
	return properties;
    }
}
