package bookStore;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.first.program.GitHubUtility;
import my.first.program.PropertyReader;
import my.first.program.dto.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import my.first.program.dto.Bookstore;
import java.io.IOException;

public class CreateUser {

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
    public void createNewUser() throws IOException {

        HttpPost request = new HttpPost(PropertyReader.getProperty("bookstore_new_user"));

        String json = "{\n" +
                "  \"userName\": \"user3333\",\n" +
                "  \"password\": \"TestTest#@%#%2224\"\n" +
                "}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println("Response Body: " + responseBody);


        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 201, "User creation failed with status code: " + statusCode);

        Assert.assertTrue(responseBody.contains("user3333"), "Response body does not confirm the creation of the user.");

    }

    @Test
    public void loginAsExistingUser() throws IOException {

        HttpPost request = new HttpPost(PropertyReader.getProperty("bookstore_generate_token"));
        response = client.execute(request);

        String json = "{\n" +
                "  \"userName\": \"user3333\",\n" +
                "  \"password\": \"TestTest#@%#%2224\"\n" +
                "}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println("Response Body: " + responseBody);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(responseBody);
        String token = jsonResponse.get("token").asText();

        Bookstore bookstore = new Bookstore();
        bookstore.setToken(token);


        System.out.println(bookstore.getToken());

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "User login failed with status code: " + statusCode);

    }

    @Test
    public void displayBooks() throws IOException {

        HttpGet request = new HttpGet(PropertyReader.getProperty("bookstore_books"));
        response = client.execute(request);

        String responseBody = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        String prettyPrintedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println("Pretty Printed Response: " + prettyPrintedJson);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "User login failed with status code: " + statusCode);

    }

    @Test
    public void addBooks() throws IOException {

        HttpPost request = new HttpPost(PropertyReader.getProperty("bookstore_add_books"));

        String json = "{\n" +
                "  \"isbn\": \"9781449325862\",\n" +
                "  \"isbn\": \"9781449331818\"\n" +
                "}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "Adding books failed with status code: " + statusCode);

    }




}
