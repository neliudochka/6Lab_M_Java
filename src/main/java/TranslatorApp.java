import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.Scanner;

public class TranslatorApp {

    private static final Logger myLogger = LogManager.getLogger("myLogger");
    static boolean active = true;
    private static final Locale[] locales = {Locale.getDefault(),
            new Locale("uk", "UA"),
            new Locale("bee", "BEE")};
    public static void run(Scanner scanner, Translator translator, TranslatorView translatorView) {
        translatorView.welcome();
        myLogger.info("App started");
        do {
            //окремі слова сприймає як окремий ввід
            translatorView.enterCommand();
            scanner.useDelimiter("\n");
            String command = scanner.next();
            switch(command.trim()) {
                case "help":
                    translatorView.help();
                    break;
                case "add":
                    translatorView.add();
                    String pair = scanner.next();
                    translator.addNewPair(pair);
                    break;
                case "translate":
                    translatorView.translate();
                    String phrase = scanner.next();
                    String translated = translator.translatePhrase(phrase);
                    translatorView.translated(translated);
                    break;
                case "lang":
                    translatorView.changeLanguage();
                    int n = scanner.nextInt();
                    try {
                        translatorView.changeLocale(getLocale(n));
                        myLogger.info("Changed language to " + getLocale(n).getDisplayLanguage());
                    } catch (RuntimeException e) {
                        myLogger.error(e.getMessage());
                    }
                    break;
                case "exit":
                    translatorView.exit();
                    myLogger.info("Exited application.");
                    System.exit(0);

                default:
                    translatorView.invalidCommand();
                    myLogger.warn("Invalid command entered: " + command);
                    break;
            }
        } while (active);
    }

    private static Locale getLocale(int n) {
        if(n<0||n>=locales.length)
            throw new RuntimeException("Index must be from 0 to " + (locales.length-1));
        return locales[n];
    }
}
