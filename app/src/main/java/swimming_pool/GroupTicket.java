package swimming_pool;

public class GroupTicket extends Ticket{
    
    private Person[] people;
    private boolean is_group;
    private boolean is_course;
    private int hours;

    // group ticket mush has at least 5 people
    public GroupTicket(Person[] people, int date, int time, int hours, boolean is_course){
        this.date = date;
        this.time = time;
        this.people = people;
        is_group = (people.length >= 5);
        this.is_course = is_course;
        this.hours = hours;
    }

    public int get_personal_price(int index){
        int price = is_weekend() ? 250 : 200;
        if(people[index].is_menber()){
            price *= 0.5;
        }
        else if(people[index].is_concession() || is_group){
            price *= 0.7;
        }
        else if(time < 700){
            price *= 0.8;
        }
        return price;
    }

    public int[] get_all_people_price(){
        int[] prices = new int[people.length];
        
        for(int i = 0; i < people.length; i++){
            prices[i] = get_personal_price(i);
        }

        return prices;
    }

    public int get_price(){
        int sum = 0;

        int coach_num = 0;
        for(Person p: people){
            if(p.is_coach()){
                coach_num ++;
            }
        }

        if (is_course && coach_num > 0){
            int len = people.length;
            if(len < 10){
                sum = 3000 * hours;
            }
            // "pre preiod" change to "pre hour"
            else{
                sum = hours * (120 * coach_num + 70 * (len - coach_num));
            }
        }
        else{
            int[] prices = get_all_people_price();

            for(int p:prices){
                sum += p;
            }    
        }
        
        return sum;
    }

}