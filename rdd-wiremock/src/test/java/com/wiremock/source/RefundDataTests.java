package com.wiremock.source;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.wiremock.source.model.RefundVO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

/**
 * @author ArulThaddaeusM
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = RddWiremockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles(value = "integration")
public class RefundDataTests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090);

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() {
        mockRemoteService();
    }

    @Test
    public void getOivData() {
        ResponseEntity<RefundVO> responseEntity = testRestTemplate.exchange("http://localhost:8090/fetchOivData", HttpMethod.GET,null,
                new ParameterizedTypeReference<RefundVO>(){});

        System.out.println("Stubbed Data"+responseEntity.getBody().getAccountHolderName());
    }

    private void mockRemoteService() {
        stubFor(get(urlEqualTo("/fetchOivData"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("response.json")
                ));
    }
}
