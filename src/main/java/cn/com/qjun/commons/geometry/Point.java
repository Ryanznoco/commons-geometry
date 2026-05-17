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
public class Point implements Serializable {
    private static final long serialVersionUID = -7089076119784425607L;

    private int x;
    private int y;

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public Point move(int deltaX, int deltaY) {
        return new Point(x + deltaX, y + deltaY);
    }
}
