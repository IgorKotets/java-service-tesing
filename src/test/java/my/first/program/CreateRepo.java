package my.first.program;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class CreateRepo {

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResourse() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void createRepo() throws Exception{

        HttpPost request = new HttpPost(PropertyReader.getProperty("base_url") + "/user/repos");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + PropertyReader.getProperty("token"));

        String json = "{\"name\": \"hello-world2\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        System.out.println(json);

        response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

}


