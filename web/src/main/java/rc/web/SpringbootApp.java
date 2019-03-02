
package rc.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"rc"})
@EntityScan(basePackages = {"rc"})
@ComponentScan(basePackages = {"rc"})
@Import({BeanConfig.class})


public class SpringbootApp extends SpringBootServletInitializer {

    private static Class applicationClass = SpringbootApp.class;
    public static void main(String[] args) {
        
          SpringApplication.run(SpringbootApp.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}
