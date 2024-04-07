package io.github.tttol.javaawssdkv2secretmanagerexample.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

@Service
@Slf4j
/**
 * AwsService
 *
 * https://github.com/awsdocs/aws-doc-sdk-examples/blob/main/javav2/example_code/secretsmanager/src/main/java/com/example/secrets/GetSecretValue.java
 */
public class AwsService {
    public static String getSecret() {
        var secretName = "sample";
        var region = Region.AP_NORTHEAST_1;
        SecretsManagerClient secretsClient = SecretsManagerClient.builder()
                .region(region)
                .build();

        var value = getValue(secretsClient, secretName);
        secretsClient.close();    
        return value;
    }

    public static String getValue(SecretsManagerClient secretsClient, String secretName) {
        try {
            GetSecretValueRequest valueRequest = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse valueResponse = secretsClient.getSecretValue(valueRequest);
            var secret = valueResponse.secretString();
            return secret;

        } catch (SecretsManagerException e) {
            log.error("error message={}", e.awsErrorDetails().errorMessage(), e);
            throw new RuntimeException(e);
        }
    }
}