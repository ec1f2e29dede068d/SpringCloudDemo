import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class EurekaColonyClient {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i = 0; i < 6; i++) {
            HttpGet httpGet = new HttpGet("http://localhost:9000/router");
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("================================================================");
            try {
                if (response != null) {
                    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("================================================================");
        }
    }

}
