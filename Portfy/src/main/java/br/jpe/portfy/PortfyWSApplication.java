package br.jpe.portfy;

import br.jpe.portfy.config.DefaultProfiles;
import java.net.UnknownHostException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Main Entry Point
 *
 * @author joaovperin
 */
@Configuration
@EnableConfigurationProperties
@SpringBootApplication
public class PortfyWSApplication {

    /**
     * Runs the app
     *
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(PortfyWSApplication.class);
        DefaultProfiles.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
    }

}
