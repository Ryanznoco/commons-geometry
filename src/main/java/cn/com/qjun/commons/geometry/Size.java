package cn.com.qjun.commons.geometry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author RenQiang
 * @date 2025/11/23
 */
@Data
@ToString
@EqualsAndHashCode
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Size {
    private int width;
    private int height;

    public static Size of(int width, int height) {
        if (width < 0) {
            throw new IllegalArgumentException("width cannot be negative: " + width);
        }
        if (height < 0) {
            throw new IllegalArgumentException("height cannot be negative: " + height);
        }
        return new Size(width, height);
    }
}
