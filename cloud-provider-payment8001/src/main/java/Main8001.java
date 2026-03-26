import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 支付微服务主启动类
 * 冯子力-23090200149
 */
@SpringBootApplication
@MapperScan("com.fengzili.cloud.mapper") // 扫描tk.mybatis的Mapper接口
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}