package cn.com.qjun.commons.geometry;

import lombok.*;

/**
 * @author RenQiang
 * @date 2025/11/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Rect {
    private int x;
    private int y;
    private int width;
    private int height;

    public static Rect ofPoint(int x1, int y1, int x2, int y2) {
        return new Rect(x1, y1, x2 - x1, y2 - y1);
    }

    public int x1() {
        return x;
    }

    public int y1() {
        return y;
    }

    public int x2() {
        return x + width;
    }

    public int y2() {
        return y + height;
    }
}
