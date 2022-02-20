package com.taxisharing.server.common.util;

import com.taxisharing.server.common.exception.HttpConnectionException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpConnector {

    private static final RestTemplate REST_TEMPLATE;

    static{
        CloseableHttpClient client = HttpClientBuilder.create()
                .setMaxConnTotal(30)
                .setMaxConnPerRoute(10)
                .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
        factory.setReadTimeout(2000);
        factory.setConnectTimeout(2000);
        REST_TEMPLATE = new RestTemplate(factory);
    }

    public static <T> String send(String url, HttpMethod method, HttpEntity<T> entity) {
        return send(url, method, entity, String.class);
    }

    public static <T, U> T send(String url, HttpMethod method, HttpEntity<U> entity, ParameterizedTypeReference<T> returnType) {
        try {
            return REST_TEMPLATE.exchange(url, method, entity, returnType).getBody();
        } catch (RestClientException e) {
            throw new HttpConnectionException();
        }
    }

    public static <T, U> T send(String url, HttpMethod method, HttpEntity<U> entity, Class<T> returnType) {
        try {
            return REST_TEMPLATE.exchange(url, method, entity, returnType).getBody();
        } catch (RestClientException e) {
            throw new HttpConnectionException();
        }
    }
}
