import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class I18NManager {

    private static I18NManager manager;
    private HashMap<String, Properties> cache;

    final static Logger logger = Logger.getLogger(I18NManager.class);

    private I18NManager(){
        this.cache = new HashMap<String, Properties>();//new I18NManagerCache();
    }

    public static I18NManager getManager(){
        if(manager == null){
            manager = new I18NManager();
        }
        return manager;
    }

    public void printFromKey(String key){

        File directory = new File("src\\main\\resources");
        String[] files = directory.list();

        for(int i = 0; i<files.length; i++){
            getValue(key,files[i]);
        }
    }

    public String getValue(String key, String filename) {

        Properties p = cache.get(filename);
        if (p == null) {
            logger.info("no tenim "+filename+" en cache");
            InputStream readerCA = I18NManager.class.getResourceAsStream(filename+".properties");

            logger.info("reader "+readerCA);
            // ResourceBundle
            p = new Properties();

            try {
                p.load(readerCA);
            } catch (IOException e) {
                e.printStackTrace();
            }

            cache.put (filename, p);
            logger.info("afegim properties associat a "+filename);

            logger.info("From file: " + filename + ". the value of the key: " + key + " is: " + p.getProperty(key));
        }
        else {
            logger.info(" "+filename+" el tenim a cache");
        }
        return p.getProperty(key);
    }


    public static void main(String[] args) {
        String v = I18NManager.getManager().getValue("k1", "ca");
        v = I18NManager.getManager().getValue("k1", "ca");
       // Assert.... "hola",v)
    }

}
