package com.wiremock.source;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootApplication
public class RddWiremockApplication {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer();

        wireMockServer.start();

        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/fetchOivData")).willReturn(aResponse().withStatus(200)
                .withHeader("Content-Type", "application/json").withBodyFile("response.json")));


        SpringApplication.run(RddWiremockApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
