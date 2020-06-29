package indeed.dubbo;

import indeed.dubbo.api.dto.ResultDto;
import indeed.dubbo.api.service.GeneratedService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class TestContiPerf {

    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    private GeneratedService generatedService;

    public TestContiPerf() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();
        generatedService =context.getBean(GeneratedService.class);
    }

    @Test
    @PerfTest(threads = 100,invocations=1000000)
    public void test() throws Exception {
        ResultDto<Long> hello = generatedService.getId("test");
        System.out.println("线程[" + Thread.currentThread().getId() + "] 获取响应的ID为: " + hello.getData());
    }
}
