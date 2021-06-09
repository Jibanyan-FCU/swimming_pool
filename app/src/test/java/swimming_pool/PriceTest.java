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
    @Test void test_illegal_minent(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new PersonalTicket(null, 2, 1290));

        assertEquals("Incorrect value of minute(00~59)", e.getMessage());
    }
    // illegal date
    @Test void test_illegal_date(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new PersonalTicket(null, 9, 1200));

        assertEquals("Number of date is out of range(1~7).", e.getMessage());
    }

    // illegal age
    @Test void test_illegal_age(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Person(200, false));

        assertEquals("Age too big or too small.", e.getMessage());
    }

    @Test void test_people_less_than_5(){
        Person p1 = new Person(25, true);
        Person p2 = new Person(25, false);
        Person p3 = new Person(25, false);
        Person[] people = {p1, p2, p3};

        Ticket t = new GroupTicket(people, 1, 800, 2, false);
        assertEquals(500, t.getPrice());
    }

    @Test void test_people_equal_5(){
        Person p1 = new Person(25, false);
        Person p2 = new Person(25, false);
        Person p3 = new Person(25, false);
        Person p4 = new Person(25, false);
        Person p5 = new Person(25, false);
        Person[] people = {p1, p2, p3, p4, p5};

        Ticket t = new GroupTicket(people, 5, 1800, 2, false);
        assertEquals(700, t.getPrice());
    }

    @Test void test_course_less_than_10(){
        Person p1 = new Person(25, false, "Coach");
        Person p2 = new Person(25, false);
        Person p3 = new Person(25, false);
        Person p4 = new Person(25, false);
        Person p5 = new Person(25, false);
        Person[] people = {p1, p2, p3, p4, p5};

        Ticket t = new GroupTicket(people, 2, 1700, 2, true);
        assertEquals(6000, t.getPrice());
    }

    @Test void test_course_equal_10(){
        Person p1 = new Person(25, false, "Coach");
        Person p2 = new Person(25, false);
        Person p3 = new Person(25, false);
        Person p4 = new Person(25, false);
        Person p5 = new Person(25, false);
        Person p6 = new Person(25, false);
        Person p7 = new Person(25, false, "Coach");
        Person p8 = new Person(25, false);
        Person p9 = new Person(25, false);
        Person p10 = new Person(25, false);
        Person[] people = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};

        Ticket t = new GroupTicket(people, 6, 900, 3, true);
        assertEquals(2400, t.getPrice());
    }
}