package com.dingshicheng23090200150.cloudapicommons.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "支付交易DTO")
public class PayDTO implements Serializable {
    private Integer id;
    @Schema(title = "支付流水号")
    private String payNo;
    @Schema(title = "订单流水号")
    private String orderNo;
    @Schema(title = "用户账号ID")
    private Integer userId;
    @Schema(title = "交易金额")
    private BigDecimal amount;
}