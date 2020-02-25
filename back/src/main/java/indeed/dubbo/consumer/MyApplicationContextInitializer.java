package indeed.dubbo.consumer;

import indeed.dubbo.consumer.config.DubboConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 服务启动加载
 */
public class MyApplicationContextInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        //加载配置文件
        rootContext.register(DubboConfig.class);

        //配置dispatcherServlet
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        servletContext.addListener(new ContextLoaderListener(rootContext));
    }
}

