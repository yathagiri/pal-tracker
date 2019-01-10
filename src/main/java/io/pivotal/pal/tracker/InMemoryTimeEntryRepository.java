package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(timeEntryMap.size()+1);
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        if(timeEntryMap.containsKey(id)){
            return timeEntryMap.get(id);
        }
        return null;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if(timeEntryMap.containsKey(id)){
            timeEntry.setId(id);
            timeEntryMap.put(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        timeEntryMap.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }

}
