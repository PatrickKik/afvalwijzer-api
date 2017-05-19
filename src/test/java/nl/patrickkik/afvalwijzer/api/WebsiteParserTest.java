package nl.patrickkik.afvalwijzer.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class WebsiteParserTest {

    @Test
    public void parse() throws Exception {

        Document document = Jsoup.connect("https://www.mijnafvalwijzer.nl/nl/{postcode}/{huisnummer}/").get();

        Kalender kalender = new WebsiteParser().parse(document);

        kalender.get().forEach((datum, afvalType) -> System.out.println(datum + ": " + afvalType.getPretty()));

    }
}