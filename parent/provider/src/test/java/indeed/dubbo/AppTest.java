package indeed.dubbo;

import indeed.dubbo.provider.AppStarter;
import indeed.dubbo.provider.service.SnowFlakesGeneratedService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStarter.class)
public class AppTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Autowired
    private SnowFlakesGeneratedService snowFlakesGeneratedService;

    @Test
    @PerfTest(threads = 1000, invocations = 1500)
//    @PerfTest(threads = 100, duration = 1500)
    public void findAll() {
        System.out.printf("ID: %d", snowFlakesGeneratedService.getId("test").get().getData());
    }
}
