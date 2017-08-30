package http;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

import static org.springframework.http.HttpMethod.GET;


public class HttpClientImplementation implements HttpClient {

    private RestTemplate restTemplate;
    private Map<String, String> headerList = new HashMap<>();
    private HttpHeaders httpHeaderObject = new HttpHeaders();
    public ResponseEntity responseEntity;
    public String service = "";

    public HttpClientImplementation(String protocol, String user, String key,String domain,String port) {
        restTemplate = new RestTemplate();
        String PROTOCOL = protocol;
        String USER = user;
        String KEY = key;
        String DOMAIN = domain;
        String PORT = port;
        service=  PROTOCOL + "://" + USER + KEY  + DOMAIN  + PORT;
    }

    public ResponseEntity doRequest(HttpMethod method,String resource,String queryParameters,Class responseObject) {

        httpHeaderObject.setAll(headerList);
        switch (method) {
            case GET:
                HttpEntity<Object> entity = new HttpEntity<>(null, httpHeaderObject);
                return responseEntity = restTemplate.exchange(service+resource+queryParameters, GET, entity, responseObject);

            default:
                HttpEntity<Object> entityD = new HttpEntity<>(null, httpHeaderObject);
                return responseEntity = restTemplate.exchange(service+resource+queryParameters, GET, entityD, responseObject);

        }




    }


}
