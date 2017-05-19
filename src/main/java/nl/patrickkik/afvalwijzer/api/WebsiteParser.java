package nl.patrickkik.afvalwijzer.api;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
class WebsiteParser {

    private static final Pattern PATTERN = Pattern.compile("^\\w+ (\\d{2} \\w+)");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM", Locale.forLanguageTag("nl"));

    Kalender parse(Document website) {
        final Kalender kalender = new Kalender();

        website.select("p.gft, p.papier, p.pmd")
                .forEach(element -> AfvalType.of(element.attr("class"))
                        .ifPresent(afvalType -> {
                            final Matcher matcher = PATTERN.matcher(element.text());
                            if (matcher.find()) {
                                final LocalDate localDate = Year.now()
                                        .atMonthDay(MonthDay.parse(matcher.group(1), DATE_TIME_FORMATTER));
                                kalender.add(localDate, afvalType);
                            }
                        }));

        return kalender;
    }

}
