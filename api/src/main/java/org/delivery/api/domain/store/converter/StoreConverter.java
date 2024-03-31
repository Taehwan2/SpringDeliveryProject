package org.delivery.api.domain.store.converter;

import org.delivery.api.common.annotation.Converter;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.store.controller.model.StoreRegisterRequest;
import org.delivery.api.domain.store.controller.model.StoreResponse;
import org.delivery.db.store.StoreEntity;

import java.util.Optional;

@Converter
public class StoreConverter {

    public StoreEntity toEntity(StoreRegisterRequest storeRegisterRequest) {

        return Optional.ofNullable(storeRegisterRequest)
                .map(it -> {

                    return StoreEntity.builder()
                            .name(storeRegisterRequest.getName())
                            .address(storeRegisterRequest.getAddress())
                            .category(storeRegisterRequest.getStoreCategory())
                            .minimumAmount(storeRegisterRequest.getMinimumAmount())
                            .minimumDeliveryAmount(storeRegisterRequest.getMinimumDeliveryAmount())
                            .thumbnailUrl(storeRegisterRequest.getThumbnailUrl())
                            .phoneNumber(storeRegisterRequest.getPhoneNumber())
                            .build();
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }

    public StoreResponse toResponse(StoreEntity store) {
        return Optional.ofNullable(store)
                .map(it -> {
                    return StoreResponse.builder()
                            .id(store.getId())
                            .name(store.getName())
                            .address(store.getAddress())
                            .category(store.getCategory())
                            .address(store.getAddress())
                            .minimumAmount(store.getMinimumAmount())
                            .minimumDeliveryAmount(store.getMinimumDeliveryAmount())
                            .thumbnailUrl(store.getThumbnailUrl())
                            .phoneNumber(store.getPhoneNumber())
                            .star(store.getStar())
                            .build();

                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));

    }
}