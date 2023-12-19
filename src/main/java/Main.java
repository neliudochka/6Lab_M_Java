import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        HashMap<String,String> dic = new HashMap<>();
        dic.put("dog", "пес");
        dic.put("eat", "їсти");
        dic.put("meat", "м'ясо");
        dic.put("cat", "кішка");
        dic.put("get", "отримати");
        dic.put("honey", "мед");
        dic.put("star", "зірка");

        Translator translator = new Translator();
        translator.addDictionary(dic);

        System.out.println("Lab 6: Translator");
        Scanner scanner = new Scanner(System.in);

        LocalizationManager manager = new LocalizationManager();
        TranslatorView tv = new TranslatorView(System.out, manager);
        TranslatorApp.run(scanner, translator, tv);
     }
}