package nl.patrickkik.afvalwijzer.api;

import java.time.LocalDate;
import java.util.*;

class Kalender {

    private final SortedMap<LocalDate, AfvalType> kalender = new TreeMap<>();

    Kalender add(LocalDate datum, AfvalType afvalType) {
        kalender.put(datum, afvalType);
        return this;
    }

    Optional<AfvalType> get(LocalDate datum) {
        return Optional.ofNullable(kalender.get(datum));
    }

    SortedMap<LocalDate, AfvalType> get() {
        return kalender;
    }

}
