package com.example.demo.阿里云配置https;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @Auther: ZHAO
 * @Date: 2018/10/30 20:12
 * @Description:
 */
@Configuration
public class HttpsConfiguration {

    /**
     * https://www.jianshu.com/p/830a4ef48c7d  j借鉴此文  本类中所讲为springboot 2.0 的版本及以后
     * @return
     */



    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(createSslConnector());
        return tomcat;
    }
    private Connector createSslConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        //            File keystore = new ClassPathResource("classpath:cert-1540947716147_www.hzmhmb.com.pfx").getFile();
        /*File truststore = new ClassPathResource("sample.jks").getFile();*/
        File keystore = new File("cert-1540947716147_www.hzmhmb.com.pfx");//加载ssl文件
        connector.setScheme("https");
        connector.setSecure(true);
        connector.setPort(443); //https 端口号
        protocol.setSSLEnabled(true);
        protocol.setKeystoreFile(keystore.getAbsolutePath());
        protocol.setKeystorePass("b4Ydj2h6");//ssl密码
        protocol.setKeyPass("b4Ydj2h6");//ssl密码
        return connector;
    }
}
