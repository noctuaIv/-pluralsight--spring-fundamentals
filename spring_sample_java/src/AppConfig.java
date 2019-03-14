import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.pluralsight"})
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name="customerService")
	@Scope("singleton")
	public CustomerService getCustomerService(){
		//CustomerServiceImpl cutomerService = new CustomerServiceImpl(getCustomerRepository());
		//cutomerService.setCustomerRepository(getCustomerRepository());
		
		CustomerServiceImpl cutomerService = new CustomerServiceImpl();
		
		return cutomerService;
	}
	
	/*@Bean(name="customerRepository")
	public CustomerRepository getCustomerRepository(){
		return new HibernateCustomerRepositoryImpl();
	}*/
}
