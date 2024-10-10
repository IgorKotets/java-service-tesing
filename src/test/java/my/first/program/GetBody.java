package my.first.program;

import my.first.program.dto.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;

public class GetBody {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResourse() throws IOException {
        if (response != null) {
            response.close();
        }
        if (client != null) {
            client.close();
        }
    }

    @Test
    public void loginTest() throws IOException {

        HttpGet request = new HttpGet(PropertyReader.getProperty("base_url") + "/users/" + User.LOGIN);
        response = client.execute(request);

        User user = GitHubUtility.deserialize(response, User.class);

        Assert.assertEquals(user.getLogin(), User.LOGIN);

    }


}
