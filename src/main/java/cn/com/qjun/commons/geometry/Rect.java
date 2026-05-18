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
public class Rect implements Serializable {
    private static final long serialVersionUID = 433259771921149444L;

    private int x;
    private int y;
    private int width;
    private int height;

    public static Rect of(int x, int y, int width, int height) {
        if (width < 0) {
            throw new IllegalArgumentException("width cannot be negative: " + width);
        }
        if (height < 0) {
            throw new IllegalArgumentException("height cannot be negative: " + height);
        }
        return new Rect(x, y, width, height);
    }

    public static Rect of(Point point, Size size) {
        if (point == null) {
            throw new IllegalArgumentException("point cannot be null");
        }
        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }
        return new Rect(point.x(), point.y(), size.width(), size.height());
    }

    public static Rect ofPoint(int x1, int y1, int x2, int y2) {
        int width = x2 - x1;
        int height = y2 - y1;
        if (width < 0) {
            throw new IllegalArgumentException("x2 must be greater than or equal to x1, but x1=" + x1 + ", x2=" + x2);
        }
        if (height < 0) {
            throw new IllegalArgumentException("y2 must be greater than or equal to y1, but y1=" + y1 + ", y2=" + y2);
        }
        return new Rect(x1, y1, width, height);
    }

    public static Rect ofPoint(Point point1, Point point2) {
        if (point1 == null) {
            throw new IllegalArgumentException("point1 cannot be null");
        }
        if (point2 == null) {
            throw new IllegalArgumentException("point2 cannot be null");
        }
        int width = point2.x() - point1.x();
        int height = point2.y() - point1.y();
        if (width < 0) {
            throw new IllegalArgumentException("point2.x must be greater than or equal to point1.x, but point1.x=" + point1.x() + ", point2.x=" + point2.x());
        }
        if (height < 0) {
            throw new IllegalArgumentException("point2.y must be greater than or equal to point1.y, but point1.y=" + point1.y() + ", point2.y=" + point2.y());
        }
        return new Rect(point1.x(), point1.y(), width, height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public Point point() {
        return Point.of(x, y);
    }

    public Size size() {
        return Size.of(width, height);
    }
}
