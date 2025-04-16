package info.suho.alarm.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        WebhookProperties.class,
})
public class PropertiesConfig {}
