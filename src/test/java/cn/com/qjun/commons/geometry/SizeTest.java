package cn.com.qjun.commons.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RenQiang
 * @date 2025/11/23
 */
class SizeTest {

    @Test
    void testOf() {
        Size size = Size.of(100, 200);
        assertNotNull(size);
        assertEquals(100, size.width());
        assertEquals(200, size.height());
    }

    @Test
    void testOfWithZero() {
        Size size = Size.of(0, 0);
        assertNotNull(size);
        assertEquals(0, size.width());
        assertEquals(0, size.height());
    }

    @Test
    void testOfWithNegativeWidth() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Size.of(-10, 100)
        );
        assertTrue(exception.getMessage().contains("width cannot be negative"));
        assertTrue(exception.getMessage().contains("-10"));
    }

    @Test
    void testOfWithNegativeHeight() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Size.of(100, -20)
        );
        assertTrue(exception.getMessage().contains("height cannot be negative"));
        assertTrue(exception.getMessage().contains("-20"));
    }

    @Test
    void testOfWithBothNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Size.of(-10, -20)
        );
        assertTrue(exception.getMessage().contains("width cannot be negative"));
    }

    @Test
    void testEquals() {
        Size size1 = Size.of(100, 200);
        Size size2 = Size.of(100, 200);
        Size size3 = Size.of(100, 300);
        Size size4 = Size.of(200, 200);

        assertEquals(size1, size2);
        assertNotEquals(size1, size3);
        assertNotEquals(size1, size4);
    }

    @Test
    void testHashCode() {
        Size size1 = Size.of(100, 200);
        Size size2 = Size.of(100, 200);
        Size size3 = Size.of(100, 300);

        assertEquals(size1.hashCode(), size2.hashCode());
        assertNotEquals(size1.hashCode(), size3.hashCode());
    }

    @Test
    void testToString() {
        Size size = Size.of(100, 200);
        String str = size.toString();
        assertNotNull(str);
        assertTrue(str.contains("100"));
        assertTrue(str.contains("200"));
    }

    @Test
    void testFluentAccessors() {
        Size size = Size.of(50, 150);
        assertEquals(50, size.width());
        assertEquals(150, size.height());
    }
}

