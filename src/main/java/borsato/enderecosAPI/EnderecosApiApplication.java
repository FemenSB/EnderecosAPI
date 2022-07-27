package borsato.enderecosAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EnderecosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnderecosApiApplication.class, args);
	}

}
