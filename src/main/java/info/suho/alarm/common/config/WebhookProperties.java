package info.suho.alarm.common.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "webhook")
public class WebhookProperties {
    private Discord discord;

    @Getter
    @Setter
    public static class Discord {
        private String url;
    }
}
