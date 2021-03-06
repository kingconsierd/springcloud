package king.consierd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，
 * 所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件spring cloud config
 * 它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。
 * 在spring cloud config 组件中，分两个角色，一是config server，二是config client。
 *
 * -- 分布式配置中心 config server, 从远程仓库获取配置信息
 * 	 	pom:	spring-cloud-config-server
 * 	 	anno:	@EnableConfigServer
 * 	 	prop:	配置资源路径等信息
 *
 *
 * -- 将配置中心做成一个微服务, 将其集群化, 从而达到高可用
 * 		pom:	spring-cloud-starter-eureka
 * 		anno:	@EnableEurekaClient
 * 		yml:	指定服务注册地址
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
