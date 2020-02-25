package indeed.dubbo.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2020-02-21
 * @version 
 */
//@Configuration
//@DubboComponentScan(basePackages = {"indeed.dubbo.provider.service"})
public class DubboConfig {

    /**
     * 应用名
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        applicationConfig.setName("provider");
        return applicationConfig;
    }

    /**
     * <dubbo:provider timeout="10000" />
     *
     * @return
     */
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig=new ProviderConfig();
        providerConfig.setTimeout(10000);
//        providerConfig.setFilter("monitorArgFilter");
        return providerConfig;
    }


    /**
     * 地址配置 <dubbo:registry address="zookeeper://127.0.0.1:2181" client="zkclient"/>
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig=new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
//        registryConfig.setAddress("192.168.43.172:2181,192.168.43.172:2182,192.168.43.172:2183");
//        registryConfig.setAddress("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183");
        registryConfig.setAddress("192.168.43.172:2281");
//        registryConfig.setClient("zkclient");
        return registryConfig;
    }


    /**
     * 协议配置，等同于 <dubbo:protocol name="dubbo" port="20880" />
     *
     * @return ProtocolConfig
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(1000);
        return protocolConfig;
    }

//    @Bean
//    public AnnotationBean annotationBean (){
//        AnnotationBean annotationBean = new AnnotationBean();
//        annotationBean.setPackage("indeed.dubbo.provider.service");
//        return annotationBean;
//    }
}

