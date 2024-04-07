package io.github.tttol.javaawssdkv2secretmanagerexample;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.tttol.javaawssdkv2secretmanagerexample.service.AwsService;

@SpringBootApplication
public class JavaAwssdkv2SecretManagerExampleApplication {
    private static final Logger logger = Logger.getLogger(JavaAwssdkv2SecretManagerExampleApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(JavaAwssdkv2SecretManagerExampleApplication.class, args);

        var sec = AwsService.getSecret();
        logger.info("secret=%s".formatted(sec));
    }
}
