package cn.j.sbdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class UserCustomer {
    @Id
    private Integer id;

    private BigDecimal balance;
}