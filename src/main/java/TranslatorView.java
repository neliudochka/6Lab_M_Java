import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.util.Locale;

public class TranslatorView {
    private final PrintStream out;
    private final LocalizationManager manager;

    public TranslatorView (PrintStream output, LocalizationManager manager) {
        this.out =  output;
        this.manager = manager;
    }
    public void changeLocale(Locale locale) {
        manager.loadLocale(locale);
        welcome();
    }
    public void welcome() {
        out.println(manager.getMessage("welcome"));
        help();
    }

    public void help() {
        out.println(manager.getMessage("help"));
    }

    public void exit() {
        out.println(manager.getMessage("bye"));
    }

    public void add() {
        out.println(manager.getMessage("add"));
    };
    public void translate() {
        out.println(manager.getMessage("translate"));
    };

    public void enterCommand() {
        out.println(manager.getMessage("enter"));
    }

    public void invalidCommand() {
        out.println(manager.getMessage("invalid"));
    };

    public void warning(String message) {
        out.println(manager.getMessage("warningPrefix") + message);
    }

    public void translated(String translation) {
        out.println(manager.getMessage("translation") + translation);
    }

    public void changeLanguage() {
        out.println(manager.getMessage("changeLanguage"));
    }
}
