package swimming_pool;

public abstract class Ticket{
    protected int date;
    protected int time;

    public abstract int getPrice();

    public boolean isWeekend(){
        return date == 6 || date == 7;
    }

    public boolean isDiscountTime(){
        return time < 700;
    }

    public void dateLimit() throws IllegalArgumentException{
        if(date < 1 || date > 7){
            throw new IllegalArgumentException("Number of date is out of range(1~7).");
        }
    }

    public void timeLimit() throws IllegalArgumentException{
        if(time < 500 || time >= 2200){
            throw new IllegalArgumentException("Number of time is out of range(0500~2200).");
        }
        else if((time % 100)> 59 && (time%100)!=0){
            throw new IllegalArgumentException("Incorrect value of minute(00~59)");
        }
    }
}


