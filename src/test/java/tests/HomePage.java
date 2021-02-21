package tests;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomePage extends TestSetup {
    static final Logger logger = LogManager.getLogger(HomePage.class);

    @Test
    public void TestHome() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(BASE_URL).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        logger.debug("Connection is Established");
        Assert.assertTrue("Page Successfully loaded.",
                connection.getResponseCode() >= HttpStatus.SC_OK &&
                        connection.getResponseCode() < HttpStatus.SC_BAD_REQUEST);
    }
}
