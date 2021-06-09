package swimming_pool;

public class PersonalTicket extends Ticket{
    
    Person person;
    
    public PersonalTicket(Person p, int date, int time) throws IllegalArgumentException{
        this.date = date;
        this.time = time;
        this.person = p;

        dateLimit();
        timeLimit();
    }

    public int getPrice(){

        int price = isWeekend() ? 250 : 200;
        if(person.isMenber()){
            price *= 0.5;
        }
        // a person can't get group ticket
        else if(person.isConcession()){
            price *= 0.7;
        }
        else if(time < 700){
            price *= 0.8;
        }
        
        return price;
    }
}