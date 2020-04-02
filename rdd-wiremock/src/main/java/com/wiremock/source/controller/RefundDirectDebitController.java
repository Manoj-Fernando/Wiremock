package com.wiremock.source.controller;

import com.wiremock.source.model.RefundVO;
import com.wiremock.source.component.FetchDetailsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ArulThaddaeusM
 */

@RestController
public class RefundDirectDebitController {

    @Autowired
    FetchDetailsComponent fetchDetailsComponent;

    @RequestMapping("/getRefundDetails")
    public RefundVO getRefundDirectDebitDetails(){

        return fetchDetailsComponent.fetchOivDetails();
    }
}
