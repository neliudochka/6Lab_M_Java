import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    @Test
    void addNewPairOfWords_ArgTwoString() {
        String en = "help";
        String ua = "допоможіть";

        Translator tr = new Translator();
        tr.addNewPair(en, ua);
        assertEquals(ua, tr.translatePhrase(en));
    }

    @Test
    void addNewPairOfWords_ArgOneString() {
        String en = "help";
        String ua = "допоможіть";

        Translator tr = new Translator();
        tr.addNewPair(en + " " + ua);
        assertEquals(ua, tr.translatePhrase(en));
    }


    @Test
    void addNewPairOfWords_ArgThreeAndMoreString() {
        String en = "help";
        String ua = "допоможіть";

        Translator tr = new Translator();

        String exceptionMessage = "You need to enter exactly 2 words!";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                tr.addNewPair(en + " " + ua + " " + "hehhehe"));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void addDifferentMeaning() {
        String en = "help";
        String ua1 = "допоможіть";
        String ua2 = "памагітє";

        Translator tr = new Translator();
        tr.addNewPair(en, ua1);
        tr.addNewPair(en, ua2);

        assertEquals(ua2, tr.translatePhrase(en));
    }

    @Test
    void translateOneWord() {
        String en1 = "cat";
        String ua1 = "кіт";
        String en2 = "dog";
        String ua2 = "пес";
        Translator tr = new Translator();
        tr.addNewPair(en1, ua1);
        tr.addNewPair(en2, ua2);

        assertEquals(ua2, tr.translatePhrase(en2));
        assertEquals(ua1, tr.translatePhrase(en1));
    }

    @Test
    void translateNotAddedWord() {
        String en1 = "cat";
        String expected = "no translation";
        Translator tr = new Translator();

        assertEquals(expected, tr.translatePhrase(en1));
    }

    @Test
    void translateMultiplyWords() {
        String en0 = "Wow";
        String ua0 = "no translation";

        String en1 = "cat";
        String ua1 = "кіт";

        String en2 = "eat";
        String ua2 = "їсти";

        String en3 = "dog";
        String ua3 = "миша";

        Translator tr = new Translator();
        tr.addNewPair(en1, ua1);
        tr.addNewPair(en2, ua2);
        tr.addNewPair(en3, ua3);
        assertEquals(ua0+" "+ua1+" "+ua2+" "+ua3, tr.translatePhrase(en0+", "+en1+" "+en2+" "+en3));
    }
}