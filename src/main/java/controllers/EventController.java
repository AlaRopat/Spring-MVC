package controllers;

import dto.EventDTO;
import entities.Event;
import entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.EventService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nikolay Shuvaev on 10.05.2017
 */
@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping()
    public ModelAndView getAllEvents() {
        List<Event> all = eventService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("event/events");
        List<EventDTO> eventDTOs = all.stream()
                .map(EventDTO::of)
                .collect(Collectors.toList());
        modelAndView.addObject("all_events", eventDTOs);
        return modelAndView;
    }

    @GetMapping(path = "/add")
    public ModelAndView addEventPage() {
        ModelAndView modelAndView = new ModelAndView("event/add_event");
        modelAndView.addObject("ratings",Rating.values());
        return modelAndView;
    }

    @PostMapping(path = "/add")
    public String addEvent(@RequestParam("name") String name, @RequestParam("basePrice") Double basePrice, @RequestParam("rating") Rating rating) {
        if (name == null) {
            return "redirect:/events/add?error=name";
        }
        if (basePrice == null) {
            return "redirect:/events/add?error=basePrice";
        }
        if (rating == null) {
            return "redirect:/events/add?error=rating";
        }

        long eventId = eventService.save(name, basePrice, rating);
        return "redirect:/events";
    }

    @GetMapping(path = "/{eventId}")
    public ModelAndView showEvent(@PathVariable("eventId") Long id) {
        Event event = eventService.getById(id);
        ModelAndView modelAndView = new ModelAndView("event/show_event");
        modelAndView.addObject("event", EventDTO.of(event));
        return modelAndView;
    }

    @PostMapping(path = "/{eventId}/delete")
    public String deleteEventSubmit(@PathVariable("eventId") Long id) {
        eventService.remove(id);
        return "redirect:/events";
    }

    @GetMapping(path = "/search")
    public String searchEvent(@RequestParam("name") String name) {
        Event event = eventService.getEventByName(name.trim());
        if (event == null) {
            return "redirect:/events";
        }
        return "forward:/events/" + event.getId();
    }
}
