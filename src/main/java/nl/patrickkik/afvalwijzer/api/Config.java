package nl.patrickkik.afvalwijzer.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Config {

    private String url;

    public String getUrl() {
        return url;
    }

    public String getUrl(String postcode, String huisnummer) {
        return String.format(url, postcode, huisnummer);
    }

    @Value("url")
    public void setUrl(String url) {
        this.url = url;
    }
}
