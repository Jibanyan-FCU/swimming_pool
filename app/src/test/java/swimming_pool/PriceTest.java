package swimming_pool;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest{

    /**
     * Test a person
     */

    // 2, 1200, is menber
    @Test void testIsMenber(){
        Person p = new Person(25, true);
        PersonalTicket t = new PersonalTicket(p, 2, 1200);

        int resule = t.getPrice();
        assertEquals(100, resule);
    }

    // 6, 1200
    @Test void test_2_1200(){
        Person p = new Person(25, false);
        PersonalTicket t = new PersonalTicket(p, 6, 1200);

        assertEquals(250, t.getPrice());
    }

    // 2, 0600
    @Test void test_2_0630(){
        Person p = new Person(25, false);
        PersonalTicket t = new PersonalTicket(p, 2, 600);

        assertEquals(160, t.getPrice());
    }

    // age: 4
    @Test void test_age_4(){
        Person p = new Person(4, false);
        PersonalTicket t = new PersonalTicket(p, 2, 1200);

        assertEquals(140, t.getPrice());
    }

    // age: 66
    @Test void test_age_66(){
        Person p = new Person(66, false);
        PersonalTicket t = new PersonalTicket(p, 2, 1200);

        assertEquals(140, t.getPrice());
    }

    // normal
    @Test void test_normal(){
        Person p = new Person(27, false);
        PersonalTicket t = new PersonalTicket(p, 5, 1130);

        assertEquals(200, t.getPrice());
    }

    // illegal time
    @Test void test_illegal_time(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new PersonalTicket(null, 2, 2300));

        assertEquals("Number of time is out of range(0500~2200).", e.getMessage());
    }

    
    // illegal minent
    @Test public void test_illegal_minent(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new PersonalTicket(null, 2, 1290));

        assertEquals("Incorrect value of minute(00~59)", e.getMessage());
    }
    // illegal date
    @Test public void test_illegal_date(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new PersonalTicket(null, 9, 1200));

        assertEquals("Number of date is out of range(1~7).", e.getMessage());
    }

    // illegal age
    @Test public void test_illegal_age(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Person(200, false));

        assertEquals("Age too big or too small.", e.getMessage());
    }
}