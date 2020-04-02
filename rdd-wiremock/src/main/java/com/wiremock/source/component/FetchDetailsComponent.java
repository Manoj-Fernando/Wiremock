package com.wiremock.source.component;

import com.wiremock.source.model.RefundVO;

/**
 * @author ArulThaddaeusM
 */
public interface FetchDetailsComponent {

    /**
     * The method to fetch details from the oiv service
     * @return RefundVO
     */
    public RefundVO fetchOivDetails();
}
