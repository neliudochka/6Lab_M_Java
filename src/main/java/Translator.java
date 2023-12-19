import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//model
public class Translator {
    private static final Logger myLogger = LogManager.getLogger("myLogger");
    private final HashMap<String,String> dictionary = new HashMap<>();

    public void addNewPair(String word ,String translation) {
        try {
            dictionary.put(word, translation);
            myLogger.info("Added new pair: " + word + " -> " + translation);
        } catch (Exception e) {
            myLogger.error("Error occurred while adding pair: " + e.getMessage());
        }
    }

    public void addNewPair(String pair) {
        try {
            String[] words = pair.split("[ ,!;.]+");
            if (words.length != 2) {
                throw new IllegalArgumentException("You need to enter exactly 2 words!");
            }
            dictionary.put(words[0], words[1]);
            myLogger.info("Added new pair: " + words[0] + " -> " + words[1]);
        } catch (Exception e) {
            myLogger.error("Error occurred while adding pair: " + e.getMessage());
        }
    }

    public void addDictionary(HashMap<String,String> newDic) {
        try {
            dictionary.putAll(newDic);
            myLogger.info("Added dictionary: " + newDic);
        } catch (Exception e) {
            myLogger.error("Error occurred while adding dictionary: " + e.getMessage());
        }
    }

    public String translatePhrase(String phrase) {
        try {
            String[] words = phrase.split("[ ,!;.]+");
            List<String> wordsTranslated = new ArrayList<>();
            for (String w : words) {
                String translation = dictionary.get(w);
                if (translation == null) {
                    translation = "no translation";
                }
                wordsTranslated.add(translation);
            }
            String translatedPhrase = String.join(" ", wordsTranslated);
            myLogger.info("Translated phrase '" + phrase + "' to: '" + translatedPhrase + "'");
            return translatedPhrase;
        } catch (Exception e) {
            myLogger.error("Error occurred while translating phrase: " + e.getMessage());
            return "Error during translation";
        }
    }

}
