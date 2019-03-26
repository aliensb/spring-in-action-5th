package win.ccav.tacmal.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

@Slf4j
public class HttpClientUtils {


    public static String doGet(String url) throws Exception {
        HttpClient client=HttpClientFactory.getHttpsClient();
        HttpGet get=new HttpGet(url);
        HttpResponse response=client.execute(get);
        log.info("response status is {}",response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        String result=null;
        if (entity != null) {
            result = EntityUtils.toString(entity);
            log.info(result);
            return result;
        }
        throw new RuntimeException("http get faild");
    }


    public static void main(String[] args) throws Exception {
        doGet("https://127.0.0.1/login");
    }
}
