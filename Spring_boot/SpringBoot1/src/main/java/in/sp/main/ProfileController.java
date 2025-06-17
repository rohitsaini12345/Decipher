package in.sp.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${app.environment}")
    private String env;

    @GetMapping("/env")
    public String getEnvironment() {
        return "Current environment: " + env;
    }
}