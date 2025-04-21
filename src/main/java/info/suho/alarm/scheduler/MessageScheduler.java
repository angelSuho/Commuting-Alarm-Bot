package info.suho.alarm.scheduler;

import info.suho.alarm.common.util.alert.discord.DiscordMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;

@Component
@RequiredArgsConstructor
public class MessageScheduler {
    private final DiscordMessagingService discordMessagingService;

    // 오전 8시 55분에 실행
    @Scheduled(cron = "0 55 8 ? * MON-FRI", zone = "Asia/Seoul")
    public void sendScheduledMessageMorning() {
        discordMessagingService.sendDiscordMessages(
                "⛅출근 시간입니다! 잊지 말고 출근 체크하세요.⏰"
        );
    }

    // 오후 6시 5분에 실행
    // 평일 18:05 - 단, 메서드 안에서 '셋째 금요일'은 건너뜀
    @Scheduled(cron = "0 5 18 ? * MON-FRI", zone = "Asia/Seoul")
    public void sendScheduledMessageEvening() {
        if (isThirdFriday(LocalDate.now(ZoneId.of("Asia/Seoul")))) return;  // ← 건너뛰기
        discordMessagingService.sendDiscordMessages(
                "💻오늘 하루도 고생 많으셨어요! 퇴근 체크 잊지 마세요.⏰"
        );
    }

    // ‘셋째 금요일’ 17:05
    @Scheduled(cron = "0 5 17 ? * FRI#3", zone = "Asia/Seoul")            // '#3' -> 3번째 금요일
    public void sendScheduledMessageEveningThirdFriday() {
        discordMessagingService.sendDiscordMessages(
                "💻오늘 하루도 고생 많으셨어요! (셋째 금요일은 17:05 퇴근 😊)"
        );
    }

    /** 오늘이 셋째 금요일인지 판별 */
    private boolean isThirdFriday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.FRIDAY &&        // 금요일
        date.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 3; // 셋째 주
    }
}
