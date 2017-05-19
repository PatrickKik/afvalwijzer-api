package nl.patrickkik.afvalwijzer.api;

import java.util.Arrays;
import java.util.Optional;

enum AfvalType {

    GFT("gft", "GFT-container"),
    PK("papier", "Papier- en kartoncontainer"),
    PMD("pmd", "Plastic-, metaal- en drinkpakkencontainer");

    private final String cssClass;
    private final String pretty;

    AfvalType(String cssClass, String pretty) {
        this.cssClass = cssClass;
        this.pretty = pretty;
    }

    static Optional<AfvalType> of(String cssClass) {
        return Arrays.stream(values())
                .filter(afvalType -> afvalType.cssClass.equalsIgnoreCase(cssClass))
                .findAny();
    }

    String getPretty() {
        return pretty;
    }
}
