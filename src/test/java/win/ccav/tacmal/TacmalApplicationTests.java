package win.ccav.tacmal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import win.ccav.tacmal.reponsitory.TacoReponsitory;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TacmalApplicationTests {

    @Resource
    private TacoReponsitory tacoReponsitory;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testJPA(){
        System.out.println(      tacoReponsitory.count());
    }
}
