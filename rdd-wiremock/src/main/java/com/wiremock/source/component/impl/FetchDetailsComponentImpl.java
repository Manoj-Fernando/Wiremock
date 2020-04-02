package com.wiremock.source.component.impl;


import com.wiremock.source.component.FetchDetailsComponent;
import com.wiremock.source.model.RefundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author ArulThaddaeusM
 */
@Component
public class FetchDetailsComponentImpl implements FetchDetailsComponent {


    @Value(value = "${remote.url}")
    private String remoteServiceURL;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public RefundVO fetchOivDetails() {
        ResponseEntity<RefundVO> responseEntity = restTemplate.exchange(remoteServiceURL, HttpMethod.GET,null,
                new ParameterizedTypeReference<RefundVO>(){});
        return responseEntity.getBody();
    }


}
