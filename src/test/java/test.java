import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test {

    @Test
    public void getValueTest(){
        Assert.assertEquals("Hola",I18NManager.getInstance().getValue("k1","ca"));
        Assert.assertEquals("Hola",I18NManager.getInstance().getValue("k1","ca"));
        Assert.assertEquals("Hola",I18NManager.getInstance().getValue("k1","es"));
        Assert.assertEquals("Hola",I18NManager.getInstance().getValue("k1","es"));
        Assert.assertEquals("Hello",I18NManager.getInstance().getValue("k1","en"));
        Assert.assertEquals("Hello",I18NManager.getInstance().getValue("k1","en"));
        Assert.assertEquals("Bonjour",I18NManager.getInstance().getValue("k1","fr"));
        Assert.assertEquals("Bonjour",I18NManager.getInstance().getValue("k1","fr"));

    }



}
