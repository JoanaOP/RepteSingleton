import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class I18NManager {

    public void printFromKey(String key){

        File directory = new File("C:\\Users\\joana\\Documents\\uni\\4A\\Disseny de Serveis i Aplicacions\\Unitat 4. UML i Patrons de Disseny\\ProvaProperties\\src\\main\\resources");
        String[] files = directory.list();

        for(int i = 0; i<files.length; i++){
            getValue(key,files[i]);
        }

    }

    public void getValue(String key, String filename){

        InputStream readerCA = I18NManager.class.getResourceAsStream(filename);

        Properties p = new Properties();

        try {
            p.load(readerCA);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("From file: "+filename+". the value of the key: "+key+" is: "+p.getProperty(key));

    }

}
