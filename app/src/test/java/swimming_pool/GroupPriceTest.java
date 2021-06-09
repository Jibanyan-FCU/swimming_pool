package swimming_pool;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GroupPriceTest {
    
    /**
     * Test a group of people
     */

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

