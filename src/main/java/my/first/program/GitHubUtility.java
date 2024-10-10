package my.first.program;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import my.first.program.dto.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GitHubUtility {

    public static User deserialize (CloseableHttpResponse response, Class<User> clazz) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, clazz);
    }

//    public static <T> String serializeToJSON(T object) throws IOException {
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        return objectMapper.writeValueAsString(object);
//    }

}
