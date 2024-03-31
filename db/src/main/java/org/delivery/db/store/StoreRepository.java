package org.delivery.db.store;

import org.delivery.db.store.enums.StoreCategory;
import org.delivery.db.store.enums.StoreStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity,Long> {

    //select * from store where id = ? and status = 'REGISTERED' Orderby Id DESC
    Optional<StoreEntity> findFirstByIdAndStatusOrderByIdDesc(Long storeId, StoreStatus status);


    //selecxt * from store where status = 'REGISTERED'
    List<StoreEntity> findAllByStatusOrderByIdDesc(StoreStatus status);

    List<StoreEntity> findAllByStatusAndCategoryOrderByStarDesc(StoreStatus status, StoreCategory storeCategory);
}
