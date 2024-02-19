package com.sns.pojang.domain.store.dto.response;

import com.sns.pojang.domain.store.entity.Address;
import com.sns.pojang.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyStoreResponse {
    private String name;
    private String imageUrl;
    private Address address;
    private String businessNumber;
    private String category;
    private String storeNumber;
    private String introduction;
    private String operationTime;

    public static MyStoreResponse from(Store store) {
        return MyStoreResponse.builder()
                .name(store.getName())
                .imageUrl(store.getImageUrl())
                .address(store.getAddress())
                .businessNumber(store.getBusinessNumber())
                .category(store.getCategory())
                .storeNumber(store.getStoreNumber())
                .introduction(store.getIntroduction())
                .operationTime(store.getOperationTime())
                .build();
    }
}
