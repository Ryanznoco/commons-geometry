package cn.com.qjun.commons.geometry;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author RenQiang
 * @date 2025/11/23
 */
@Data
@ToString
@EqualsAndHashCode
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class Size implements Serializable {
    private static final long serialVersionUID = -6994522162639554389L;

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
