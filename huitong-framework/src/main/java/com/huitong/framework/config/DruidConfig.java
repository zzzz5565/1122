package com.huitong.framework.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.huitong.common.utils.security.RsaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.util.Utils;
import com.huitong.common.enums.DataSourceType;
import com.huitong.common.utils.spring.SpringUtils;
import com.huitong.framework.config.properties.DruidProperties;
import com.huitong.framework.datasource.DynamicDataSource;

/**
 * druid 配置多数据源
 *
 *
 */
@Configuration
public class DruidConfig
{
    @Value("${shiro.encryption}")
    private Boolean encryption;

    @Bean("masterDataSource")
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource(DruidProperties druidProperties)
    {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties("spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource(DruidProperties druidProperties)
    {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean("slaveDataSource2")
    @ConfigurationProperties("spring.datasource.druid.slave2")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave2", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource2(DruidProperties druidProperties)
    {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean("slaveDataSource3")
    @ConfigurationProperties("spring.datasource.druid.slave3")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave3", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource3(DruidProperties druidProperties)
    {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource)
    {
        String masterUsername = ((DruidDataSource) masterDataSource).getUsername();
        String masterPassword = ((DruidDataSource) masterDataSource).getPassword();
        if(encryption==true) {
            try {
                ((DruidDataSource) masterDataSource).setUsername(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,masterUsername));
                ((DruidDataSource) masterDataSource).setPassword(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,masterPassword));
            } catch (Exception e) {
            }
        }else{
            ((DruidDataSource) masterDataSource).setUsername(masterUsername);
            ((DruidDataSource) masterDataSource).setPassword(masterPassword);
        }
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        setDataSource(targetDataSources);
        setDataSource2(targetDataSources);//第二个从库
        setDataSource3(targetDataSources);//第三个从库
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

    /**
     * 设置数据源
     *
     * @param targetDataSources 备选数据源集合
     */
    public void setDataSource(Map<Object, Object> targetDataSources)
    {
        try {
            DataSource slaveDataSource = null;

            try{
                slaveDataSource = SpringUtils.getBean("slaveDataSource");
            }catch (Exception e){
                System.out.println("=========================================slaveDataSource未启用=========================================");
            }

            if(slaveDataSource!=null){
                String slaveUsername = ((DruidDataSource) slaveDataSource).getUsername();
                String slavePassword = ((DruidDataSource) slaveDataSource).getPassword();
                if(encryption==true) {
                    try {
                        ((DruidDataSource) slaveDataSource).setUsername(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,slaveUsername));
                        ((DruidDataSource) slaveDataSource).setPassword(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,slavePassword));
                    } catch (Exception e) {
                    }
                }else{
                    ((DruidDataSource) slaveDataSource).setUsername(slaveUsername);
                    ((DruidDataSource) slaveDataSource).setPassword(slavePassword);
                }
                targetDataSources.put(DataSourceType.SLAVE.name(), slaveDataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 设置数据源
     *
     * @param targetDataSources 备选数据源集合
     */
    public void setDataSource2(Map<Object, Object> targetDataSources)
    {
        try {
            DataSource slaveDataSource = null;

            try{
                slaveDataSource = SpringUtils.getBean("slaveDataSource2");
            }catch (Exception e){
                System.out.println("=========================================slaveDataSource2未启用=========================================");
            }

            if(slaveDataSource!=null){
                String slaveUsername = ((DruidDataSource) slaveDataSource).getUsername();
                String slavePassword = ((DruidDataSource) slaveDataSource).getPassword();
                if(encryption==true) {
                    try {
                        ((DruidDataSource) slaveDataSource).setUsername(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,slaveUsername));
                        ((DruidDataSource) slaveDataSource).setPassword(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,slavePassword));
                    } catch (Exception e) {
                    }
                }else{
                    ((DruidDataSource) slaveDataSource).setUsername(slaveUsername);
                    ((DruidDataSource) slaveDataSource).setPassword(slavePassword);
                }
                targetDataSources.put(DataSourceType.SLAVE2.name(), slaveDataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 设置数据源
     *
     * @param targetDataSources 备选数据源集合
     */
    public void setDataSource3(Map<Object, Object> targetDataSources)
    {
        try {
            DataSource slaveDataSource = null;

            try{
                slaveDataSource = SpringUtils.getBean("slaveDataSource3");
            }catch (Exception e){
                System.out.println("=========================================slaveDataSource3未启用=========================================");
            }

            if(slaveDataSource!=null){
                String slaveUsername = ((DruidDataSource) slaveDataSource).getUsername();
                String slavePassword = ((DruidDataSource) slaveDataSource).getPassword();
                if(encryption==true) {
                    try {
                        ((DruidDataSource) slaveDataSource).setUsername(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,slaveUsername));
                        ((DruidDataSource) slaveDataSource).setPassword(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,slavePassword));
                    } catch (Exception e) {
                    }
                }else{
                    ((DruidDataSource) slaveDataSource).setUsername(slaveUsername);
                    ((DruidDataSource) slaveDataSource).setPassword(slavePassword);
                }
                targetDataSources.put(DataSourceType.SLAVE3.name(), slaveDataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 去除监控页面底部的广告
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    @ConditionalOnProperty(name = "spring.datasource.druid.statViewServlet.enabled", havingValue = "true")
    public FilterRegistrationBean removeDruidFilterRegistrationBean(DruidStatProperties properties)
    {
        // 获取web监控页面的参数
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        // 提取common.js的配置路径
        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
        final String filePath = "support/http/resources/js/common.js";
        // 创建filter进行过滤
        Filter filter = new Filter()
        {
            @Override
            public void init(javax.servlet.FilterConfig filterConfig) throws ServletException
            {
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException
            {
                chain.doFilter(request, response);
                // 重置缓冲区，响应头不会被重置
                response.resetBuffer();
                // 获取common.js
                String text = Utils.readFromResource(filePath);
                // 正则替换banner, 除去底部的广告信息
                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
                text = text.replaceAll("powered.*?shrek.wang</a>", "");
                response.getWriter().write(text);
            }

            @Override
            public void destroy()
            {
            }
        };
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean druidServlet(DruidStatProperties properties) {
        // 获取web监控页面的参数
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings(config.getUrlPattern());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("resetEnable", "false"); //禁用HTML页面上的“Rest All”功能
        initParameters.put("allow", config.getAllow()); //ip白名单（没有配置或者为空，则允许所有访问）
        try {
            initParameters.put("loginUsername", RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr, config.getLoginUsername())); //监控页面登录用户名
            initParameters.put("loginPassword", RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr, config.getLoginPassword())); //监控页面登录密码
        }catch (Exception e){
            e.printStackTrace();
        }
        initParameters.put("deny", config.getDeny()); //ip黑名单
        //如果某个ip同时存在，deny优先于allow
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
}
