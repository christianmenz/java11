package ch.christianmenz.java11.localebuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

public class LocaleBuilderMain {

    public static void main(String[] args) {
        Locale.Builder builder = new Locale.Builder();
        Locale build = builder.setLanguage("de")
                .setExtension('x', "mobile-client").build();


        System.out.println(build.toLanguageTag());

        ResourceBundle resourceBundle = ResourceBundle.getBundle("ch/christianmenz/java11/localebuilder/test", build, new Control() {
            @Override
            public List<Locale> getCandidateLocales(String baseName, Locale locale) {
                List<Locale> candidateLocales = super.getCandidateLocales(baseName, locale);
                candidateLocales.add(0, locale);
                return candidateLocales;
            }

            @Override
            public List<String> getFormats(String baseName) {
                List<String> formats = super.getFormats(baseName);
                System.out.println(formats);
                return formats;
            }

            @Override
            public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
                String languageTag = locale.toLanguageTag();
                System.out.println(languageTag);
                InputStream resourceAsStream = loader.getResourceAsStream(baseName + "_" + languageTag + ".properties");
                PropertyResourceBundle propertyResourceBundle = null;
                if (resourceAsStream != null) {
                    propertyResourceBundle = new PropertyResourceBundle(resourceAsStream);
                }
                return propertyResourceBundle;
            }

            @Override
            public String toBundleName(String baseName, Locale locale) {
                String s = super.toBundleName(baseName, locale);
                System.out.println(s);
                return s;
            }
        });

        System.out.println(resourceBundle.getString("test"));
    }
}
