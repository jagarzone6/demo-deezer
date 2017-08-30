package http;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface HttpClient {

    public abstract ResponseEntity doRequest(HttpMethod method, String resource, String queryParameters, Class responseObject);

}
