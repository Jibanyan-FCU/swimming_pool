package swimming_pool;

import org.junit.Test;
import static org.junit.Assert.*;

public class PriceTest{

    // 2, 1200, is menber
    @Test public void test_is_menber(){
        Person p = new Person(25, true, false);
        PersonalTicket t = new PersonalTicket(p, 2, 1200);

        int resule = t.get_price();
        assertEquals(100, resule);
    }

    // 6, 1200
    @Test public void test_2_1200(){
        Person p = new Person(25, false, false);
        PersonalTicket t = new PersonalTicket(p, 6, 1200);

        assertEquals(250, t.get_price());
    }

    // 2, 0600
    @Test public void test_2_0630(){
        Person p = new Person(25, false, false);
        PersonalTicket t = new PersonalTicket(p, 2, 600);

        assertEquals(160, t.get_price());
    }

    // age: 4
    @Test public void test_age_4(){
        Person p = new Person(4, false, false);
        PersonalTicket t = new PersonalTicket(p, 2, 1200);

        assertEquals(140, t.get_price());
    }

    // age: 66
    @Test public void test_age_66(){
        Person p = new Person(66, false, false);
        PersonalTicket t = new PersonalTicket(p, 2, 1200);

        assertEquals(140, t.get_price());
    }

    // illegal time
    @Test public void test_illegal_time(){
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
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Person(200, false, false));

        assertEquals("Age too big or too small.", e.getMessage());
    }
}