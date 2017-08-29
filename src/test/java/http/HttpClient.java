package http;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

import static org.springframework.http.HttpMethod.GET;


public class HttpClient {

    private RestTemplate restTemplate;
    private Map<String, String> headerList = new HashMap<>();
    private ResponseEntity<String> response = null;
    private HttpHeaders httpHeaderObject = new HttpHeaders();
    public ResponseEntity responseEntity;
    public ResponseEntity<String> Stringrentity;
    public String service = "";

    public HttpClient(String protocol, String user, String key,String domain,String port) {
        restTemplate = new RestTemplate();
        String PROTOCOL = protocol;
        String USER = user;
        String KEY = key;
        String DOMAIN = domain;
        String PORT = port;
        service=  PROTOCOL + "://" + USER + KEY  + DOMAIN  + PORT +  "/";
    }
    public String UnauthorizedError;


    public void doRequest(HttpMethod method,String resource,String queryParameters,Class responseObject) {
        HttpMethod httpMethod;

        httpHeaderObject.setAll(headerList);
        switch (method) {
            case GET:
                HttpEntity<Object> entity = new HttpEntity<>(null, httpHeaderObject);
                responseEntity = restTemplate.exchange(service+resource+queryParameters, GET, entity, responseObject);
                UnauthorizedError = "";

                break;
            default:
                HttpEntity<Object> entityD = new HttpEntity<>(null, httpHeaderObject);
                responseEntity = restTemplate.exchange(service+resource+queryParameters, GET, entityD, responseObject);
                UnauthorizedError = "";

                break;
        }




    }


}
