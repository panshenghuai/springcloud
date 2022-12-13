package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 16:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServerZookeeperApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerZookeeperApplication80.class,args);
    }
}
