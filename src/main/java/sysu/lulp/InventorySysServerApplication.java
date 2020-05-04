package sysu.lulp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication //(exclude = {SecurityAutoConfiguration.class})
/// 扫描 mybatis mapper 包路径
@MapperScan(basePackages = "sysu.lulp.mapper")
public class InventorySysServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorySysServerApplication.class, args);
    }

}
