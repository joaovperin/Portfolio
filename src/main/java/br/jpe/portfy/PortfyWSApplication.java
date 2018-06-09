package br.jpe.portfy;

import br.jpe.portfy.config.DefaultProfiles;
import java.net.UnknownHostException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Main Entry Point
 *
 * @author joaovperin
 */
@EnableConfigurationProperties
@SpringBootApplication
@Configuration
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
        app.run(args);
    }

}
