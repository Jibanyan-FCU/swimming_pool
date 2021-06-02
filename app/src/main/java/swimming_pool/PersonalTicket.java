package swimming_pool;

public class PersonalTicket extends Ticket{
    
    Person person;
    
    public PersonalTicket(Person p, int date, int time) throws IllegalArgumentException{
        this.date = date;
        this.time = time;
        this.person = p;

        date_limit();
        time_limit();
    }

    public int get_price(){

        int price = is_weekend() ? 250 : 200;
        if(person.is_menber()){
            price *= 0.5;
        }
        // a person can't get group ticket
        else if(person.is_concession()){
            price *= 0.7;
        }
        else if(time < 700){
            price *= 0.8;
        }
        
        return price;
    }
}