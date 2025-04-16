package info.suho.alarm.common.util.alert.discord.embed;

import lombok.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EmbedObject {
    private String title;
    private String description;
    private String url;
    private Color color;
    private Footer footer;
    private Thumbnail thumbnail;
    private ImageFile image;
    private Author author;

    @Singular("fieldItem")
    private final List<Field> fields = new ArrayList<>();
}
