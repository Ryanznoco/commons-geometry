package cn.com.qjun.commons.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RenQiang
 * @date 2025/11/23
 */
class RectTest {

    @Test
    void testOfWithInts() {
        Rect rect = Rect.of(10, 20, 100, 200);
        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(100, rect.width());
        assertEquals(200, rect.height());
        assertEquals(110, rect.x2());
        assertEquals(220, rect.y2());
    }

    @Test
    void testOfWithIntsZeroSize() {
        Rect rect = Rect.of(10, 20, 0, 0);
        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(0, rect.width());
        assertEquals(0, rect.height());
        assertEquals(10, rect.x2());
        assertEquals(20, rect.y2());
    }

    @Test
    void testOfWithIntsNegativeWidth() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.of(10, 20, -10, 100)
        );
        assertTrue(exception.getMessage().contains("width cannot be negative"));
    }

    @Test
    void testOfWithIntsNegativeHeight() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.of(10, 20, 100, -20)
        );
        assertTrue(exception.getMessage().contains("height cannot be negative"));
    }

    @Test
    void testOfWithPointAndSize() {
        Point point = Point.of(10, 20);
        Size size = Size.of(100, 200);
        Rect rect = Rect.of(point, size);

        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(100, rect.width());
        assertEquals(200, rect.height());
    }

    @Test
    void testOfWithPointAndSizeNullPoint() {
        Size size = Size.of(100, 200);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.of(null, size)
        );
        assertTrue(exception.getMessage().contains("point cannot be null"));
    }

    @Test
    void testOfWithPointAndSizeNullSize() {
        Point point = Point.of(10, 20);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.of(point, null)
        );
        assertTrue(exception.getMessage().contains("size cannot be null"));
    }

    @Test
    void testOfPointWithInts() {
        Rect rect = Rect.ofPoint(10, 20, 110, 220);
        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(100, rect.width());
        assertEquals(200, rect.height());
        assertEquals(110, rect.x2());
        assertEquals(220, rect.y2());
    }

    @Test
    void testOfPointWithIntsEqualPoints() {
        Rect rect = Rect.ofPoint(10, 20, 10, 20);
        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(0, rect.width());
        assertEquals(0, rect.height());
    }

    @Test
    void testOfPointWithIntsX2LessThanX1() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.ofPoint(110, 20, 10, 220)
        );
        assertTrue(exception.getMessage().contains("x2 must be greater than or equal to x1"));
    }

    @Test
    void testOfPointWithIntsY2LessThanY1() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.ofPoint(10, 220, 110, 20)
        );
        assertTrue(exception.getMessage().contains("y2 must be greater than or equal to y1"));
    }

    @Test
    void testOfPointWithPoints() {
        Point point1 = Point.of(10, 20);
        Point point2 = Point.of(110, 220);
        Rect rect = Rect.ofPoint(point1, point2);

        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(100, rect.width());
        assertEquals(200, rect.height());
    }

    @Test
    void testOfPointWithPointsEqual() {
        Point point1 = Point.of(10, 20);
        Point point2 = Point.of(10, 20);
        Rect rect = Rect.ofPoint(point1, point2);

        assertNotNull(rect);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(0, rect.width());
        assertEquals(0, rect.height());
    }

    @Test
    void testOfPointWithPointsNullPoint1() {
        Point point2 = Point.of(110, 220);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.ofPoint(null, point2)
        );
        assertTrue(exception.getMessage().contains("point1 cannot be null"));
    }

    @Test
    void testOfPointWithPointsNullPoint2() {
        Point point1 = Point.of(10, 20);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.ofPoint(point1, null)
        );
        assertTrue(exception.getMessage().contains("point2 cannot be null"));
    }

    @Test
    void testOfPointWithPointsX2LessThanX1() {
        Point point1 = Point.of(110, 20);
        Point point2 = Point.of(10, 220);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.ofPoint(point1, point2)
        );
        assertTrue(exception.getMessage().contains("point2.x must be greater than or equal to point1.x"));
    }

    @Test
    void testOfPointWithPointsY2LessThanY1() {
        Point point1 = Point.of(10, 220);
        Point point2 = Point.of(110, 20);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Rect.ofPoint(point1, point2)
        );
        assertTrue(exception.getMessage().contains("point2.y must be greater than or equal to point1.y"));
    }

    @Test
    void testX1Y1X2Y2() {
        Rect rect = Rect.of(10, 20, 100, 200);
        assertEquals(10, rect.x1());
        assertEquals(20, rect.y1());
        assertEquals(110, rect.x2());
        assertEquals(220, rect.y2());
    }

    @Test
    void testX1Y1X2Y2WithNegativeCoordinates() {
        Rect rect = Rect.of(-10, -20, 100, 200);
        assertEquals(-10, rect.x1());
        assertEquals(-20, rect.y1());
        assertEquals(90, rect.x2());
        assertEquals(180, rect.y2());
    }

    @Test
    void testEquals() {
        Rect rect1 = Rect.of(10, 20, 100, 200);
        Rect rect2 = Rect.of(10, 20, 100, 200);
        Rect rect3 = Rect.of(10, 20, 100, 300);
        Rect rect4 = Rect.of(10, 30, 100, 200);

        assertEquals(rect1, rect2);
        assertNotEquals(rect1, rect3);
        assertNotEquals(rect1, rect4);
    }

    @Test
    void testHashCode() {
        Rect rect1 = Rect.of(10, 20, 100, 200);
        Rect rect2 = Rect.of(10, 20, 100, 200);
        Rect rect3 = Rect.of(10, 20, 100, 300);

        assertEquals(rect1.hashCode(), rect2.hashCode());
        assertNotEquals(rect1.hashCode(), rect3.hashCode());
    }

    @Test
    void testToString() {
        Rect rect = Rect.of(10, 20, 100, 200);
        String str = rect.toString();
        assertNotNull(str);
        assertTrue(str.contains("10"));
        assertTrue(str.contains("20"));
        assertTrue(str.contains("100"));
        assertTrue(str.contains("200"));
    }

    @Test
    void testFluentAccessors() {
        Rect rect = Rect.of(5, 15, 50, 150);
        assertEquals(5, rect.x());
        assertEquals(15, rect.y());
        assertEquals(50, rect.width());
        assertEquals(150, rect.height());
    }
}

