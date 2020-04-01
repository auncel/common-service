package dev.yidafu.auncel.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EnableRedisRepositories
public class CommonServiceApplication {
	@Autowired
	RedisTemplate redisTemplate;

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CommonServiceApplication.class, args);
//		new HelloService().hello();
	}

}
