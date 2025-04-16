package info.suho.alarm.common.util.alert.discord.embed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Footer {
    private String text;
    private String iconUrl;
}