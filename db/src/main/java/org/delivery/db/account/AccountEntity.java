package org.delivery.db.account;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;


//super build 와 builder 차이점
//builder속성에 super의 속성도 넣을 것인지 아닌지의 유무이다.
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
//부모에 있는 값만 비교할건지 현재 있는 클래스만 비교할것인지를 비교
@Entity
@Table(name = "account")
public class AccountEntity  extends BaseEntity {



}
