package info.suho.alarm.common.util.alert.discord;

import info.suho.alarm.common.config.WebhookProperties;
import info.suho.alarm.common.util.alert.discord.embed.EmbedObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiscordMessagingService {
    private final WebhookProperties webhookProperties;

    public void sendDiscordMessages(String title) {
        try {
            DiscordWebhookSender discordWebhookBot = new DiscordWebhookSender(webhookProperties.getDiscord().getUrl());
            String registeredTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

            EmbedObject embedObject = EmbedObject.builder()
                    .title(title)
//                    .description(description)
//                    .url("https://example.com")
//                    .color(Color.BLUE)
//                    .footer(Footer.builder().text("Footer Text").icon("https://icon.url").build())
//                    .thumbnail(Thumbnail.builder().url("https://thumbnail.url").build())
//                    .image(ImageFile.builder().url("https://image.url").build())
//                    .fieldItem(Field.builder().name("필드1").value("값1").inline(true).build())
//                    .fieldItem(Field.builder().name("필드2").value("값2").inline(false).build())
                    .build();

            discordWebhookBot.addEmbed(embedObject);
            discordWebhookBot.execute();
        } catch (Exception e) {
            log.debug("Discord 통신 과정에 예외 발생");
        }
    }
}
