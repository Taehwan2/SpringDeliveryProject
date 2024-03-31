package org.delivery.db.store.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public enum StoreStatus {
    REGISTERED("등록"),
    UNREGISTERED("해지");

    private String discription;
}
