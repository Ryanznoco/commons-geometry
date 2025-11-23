package cn.com.qjun.commons.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RenQiang
 * @date 2025/11/23
 */
class PointTest {

    @Test
    void testOf() {
        Point point = Point.of(10, 20);
        assertNotNull(point);
        assertEquals(10, point.x());
        assertEquals(20, point.y());
    }

    @Test
    void testOfWithNegativeCoordinates() {
        // 坐标可以为负数
        Point point = Point.of(-10, -20);
        assertNotNull(point);
        assertEquals(-10, point.x());
        assertEquals(-20, point.y());
    }

    @Test
    void testOfWithZero() {
        Point point = Point.of(0, 0);
        assertNotNull(point);
        assertEquals(0, point.x());
        assertEquals(0, point.y());
    }

    @Test
    void testEquals() {
        Point point1 = Point.of(10, 20);
        Point point2 = Point.of(10, 20);
        Point point3 = Point.of(10, 30);
        Point point4 = Point.of(20, 20);

        assertEquals(point1, point2);
        assertNotEquals(point1, point3);
        assertNotEquals(point1, point4);
    }

    @Test
    void testHashCode() {
        Point point1 = Point.of(10, 20);
        Point point2 = Point.of(10, 20);
        Point point3 = Point.of(10, 30);

        assertEquals(point1.hashCode(), point2.hashCode());
        assertNotEquals(point1.hashCode(), point3.hashCode());
    }

    @Test
    void testToString() {
        Point point = Point.of(10, 20);
        String str = point.toString();
        assertNotNull(str);
        assertTrue(str.contains("10"));
        assertTrue(str.contains("20"));
    }

    @Test
    void testFluentAccessors() {
        Point point = Point.of(5, 15);
        assertEquals(5, point.x());
        assertEquals(15, point.y());
    }
}

