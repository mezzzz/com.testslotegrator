package uitests;

import org.junit.Before;
import org.junit.Test;

public class SortPlayersTest extends BasePage {

    public static String url = "http://test-app.d6.dev.devcaz.com/admin/login";
    public static String login = "admin1";
    public static String password = "[9k<k8^z!+$$GkuP";

    @Before
    public void setup() {
        initChrome();
    }


    @Test
    public void sortPlayersTable() {
        try {
            driver.get(url);
            login(login, password);
            openPlayersTable();
            sortPlayersTableByUsername();
        } finally {
            driver.quit();
        }
    }
}





