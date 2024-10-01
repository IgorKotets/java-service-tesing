package my.first.program;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.WildcardTypePermission;
import my.first.program.dto.ValCurs;
import my.first.program.dto.Valute;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            CloseableHttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl"));
            CloseableHttpResponse response = client.execute(request);

            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(
                            response.getEntity().getContent()));

            String fullResponse = "";
            String line = "";

            while ((line = rd.readLine()) != null) {
                fullResponse += line + "\r\n";
            }

            XStream xstream = new XStream();

            xstream.addPermission(new WildcardTypePermission(new String[]{
                    "my.first.program.dto.**"
            }));

            xstream.processAnnotations(ValCurs.class);
            xstream.processAnnotations(Valute.class);

            xstream.addImplicitCollection(ValCurs.class, "valutes", Valute.class);
            ValCurs valCurs = (ValCurs) xstream.fromXML(fullResponse);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

//            NominalValueCheck checker = new NominalValueCheck();
//            checker.checkNominals(valCurs);

            ExchangeRateDisplay.displayExchangeRate(valCurs,"EUR");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}


