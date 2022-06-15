package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return " ... AWS first deployment CTRL ALT L to format ... ";
	}

	@GetMapping("/{name}")
	public String ecs(@PathVariable String name) {
		return "Hi " + name + ". Welcome to AWS ECS elastic container service. ";
	}

}
