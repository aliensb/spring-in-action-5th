package win.ccav.tacmal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "win.ccav.tacmal.reponsitory")
//@EntityScan(basePackages = "win.ccav.tacmal.domain")
public class TacmalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacmalApplication.class, args);
    }

}
