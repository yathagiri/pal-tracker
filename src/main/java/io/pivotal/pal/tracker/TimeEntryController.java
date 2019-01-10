package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        timeEntry =  timeEntryRepository.create(timeEntry);
        if(timeEntry == null)
            return new ResponseEntity<>(timeEntry, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntry =  timeEntryRepository.find(id);
        if(timeEntry == null)
            return new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        timeEntry = timeEntryRepository.update(id, timeEntry);
        if(timeEntry == null)
            return new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(timeEntry, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }
}
