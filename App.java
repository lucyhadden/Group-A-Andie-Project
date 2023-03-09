import java.util.*;
import java.util.prefs.Preferences;

public class App {

    // Hello world app, but with internationalisation
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(App.class);

        Locale.setDefault(new Locale(prefs.get("language", "en"),
                prefs.get("country", "NZ")));

        ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle");

        Scanner sc = new Scanner(System.in);
        if (bundle.getLocale() == Locale.ITALY) {
            System.out.println("Scegli una lingua");
            prefs.put("language", "it");
            System.out.println(bundle.getString("greeting"));

        } else if (bundle.getLocale() == Locale.ENGLISH) {
            System.out.println("Choose a language");
            prefs.put("language", "mi");
            System.out.println(bundle.getString("greeting"));

        }

        // System.out.println(bundle.getString("greeting"));

        // prefs.put("language", "mi");
        // prefs.put("country", "NZ");
        // prefs.put("language", "it");
        // prefs.put("country", "Italy");

    }
}
