import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationManager {
    private ResourceBundle messages;
    private final String BASE_NAME = "location.text";

    public LocalizationManager() {
        this.messages = ResourceBundle.getBundle(BASE_NAME);
    }

    public void loadLocale(Locale locale) {
        this.messages = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String getMessage(String key) {
        return this.messages.getString(key);
    }

}