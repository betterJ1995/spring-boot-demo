package cn.j.sbdemo.entity;

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
public class Product {
    @Id
    private Integer id;

    private Integer businessId;

    private BigDecimal price;

    private Integer num;

    private String detail;
}