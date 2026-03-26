package entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_pay")
@ToString
@Schema(title = "支付交易表Entity")
public class Pay {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "pay_no")
    @Schema(title = "支付流水号")
    private String payNo;

    @Column(name = "order_no")
    @Schema(title = "订单流水号")
    private String orderNo;

    @Column(name = "user_id")
    @Schema(title = "用户账号ID")
    private Integer userId;

    @Schema(title = "交易金额")
    private BigDecimal amount;

    @Schema(title = "删除标志,0不删1删")
    private Byte deleted;

    @Column(name = "create_time")
    @Schema(title = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Column(name = "update_time")
    @Schema(title = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    // 省略getter/setter（生成器已自动生成）
}