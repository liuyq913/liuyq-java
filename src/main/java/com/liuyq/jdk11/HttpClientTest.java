package com.liuyq.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author liuyuqing
 * @className HttpClientTest
 * @description
 * @date 2022/6/29 3:27 下午
 */
public class HttpClientTest {
    public static void main(String[] arggs) throws URISyntaxException, IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(new URI("https://www.baidu.com")).GET().build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
