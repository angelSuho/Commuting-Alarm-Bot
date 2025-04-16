package info.suho.alarm.scheduler;

import info.suho.alarm.common.util.alert.discord.DiscordMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageScheduler {
    private final DiscordMessagingService discordMessagingService;

    // 오전 8시 55분에 실행
//    @Scheduled(cron = "0 55 8 * * *")
    @Scheduled(cron = "0 * * * * *", zone = "Asia/Seoul")
    public void sendScheduledMessageMorning() {
        discordMessagingService.sendDiscordMessages(
                "⛅출근 시간입니다! 잊지 말고 출근 체크하세요.⏰"
        );
    }

    // 오후 6시 5분에 실행
    @Scheduled(cron = "0 5 18 * * *", zone = "Asia/Seoul")
    public void sendScheduledMessageEvening() {
        discordMessagingService.sendDiscordMessages(
                "\uD83D\uDCBB오늘 하루도 고생 많으셨어요! 퇴근 체크 잊지 마세요.⏰"
        );
    }
}
