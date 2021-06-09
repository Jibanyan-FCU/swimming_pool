package swimming_pool;

public class GroupTicket extends Ticket{
    
    private Person[] people;
    private boolean isGroup;
    private boolean isCourse;
    private int hours;

    // group ticket mush has at least 5 people
    public GroupTicket(Person[] people, int date, int time, int hours, boolean isCourse){
        this.date = date;
        this.time = time;
        this.people = people;
        isGroup = (people.length >= 5);
        this.isCourse = isCourse;
        this.hours = hours;
    }

    public int getPersonalPrice(int index){
        int price = isWeekend() ? 250 : 200;
        if(people[index].isMenber()){
            price *= 0.5;
        }
        else if(people[index].isConcession() || isGroup){
            price *= 0.7;
        }
        else if(time < 700){
            price *= 0.8;
        }
        return price;
    }

    public int[] getAllPeoplePrice(){
        int[] prices = new int[people.length];
        
        for(int i = 0; i < people.length; i++){
            prices[i] = getPersonalPrice(i);
        }

        return prices;
    }

    public int getPrice(){
        int sum = 0;

        int coach_num = 0;
        for(Person p: people){
            if(p.isCoach()){
                coach_num ++;
            }
        }

        if (isCourse && coach_num > 0){
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
            int[] prices = getAllPeoplePrice();

            for(int p:prices){
                sum += p;
            }    
        }
        
        return sum;
    }

}