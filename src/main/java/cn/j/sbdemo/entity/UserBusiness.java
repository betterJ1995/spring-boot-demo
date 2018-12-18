package cn.j.sbdemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class UserBusiness  implements Serializable {
    @Id
    private Integer id;

    private BigDecimal balance;
}