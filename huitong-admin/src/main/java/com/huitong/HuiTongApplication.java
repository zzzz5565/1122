package com.huitong;

import com.huitong.common.utils.spring.SpringUtils;
import com.huitong.web.core.config.HtApplicationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动程序
 * 
 * 
 */
@EnableAutoConfiguration
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class HuiTongApplication
{
    public final static Logger log = LoggerFactory.getLogger(HuiTongApplication.class);

    public static void main(String[] args) throws UnknownHostException
    {
        ConfigurableApplicationContext application = SpringApplication.run(HuiTongApplication.class, args);
        Environment env = application.getEnvironment();

        String ip = InetAddress.getLocalHost().getHostAddress();
        String path = env.getProperty("server.servlet.context-path");
        //String port = env.getProperty("server.port");
        int port = SpringUtils.getBean(HtApplicationEvent.class).getPort();

        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
    }
}