package com.cuzz.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	//记录器
	Logger logger = LoggerFactory.getLogger(getClass());//LoggerFactory是sl4j的

	@Test
	public void contextLoads() {
		//日志的级别；
		//由低到高   trace<debug<info<warn<error     trace：跟踪
		//可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
		logger.trace("这是trace日志...");//跟踪轨迹，代码运行轨迹
		logger.debug("这是debug日志...");//调试使用
		//SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
//		在logging.level.com.cuzz=trace配置
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");
	}

}
