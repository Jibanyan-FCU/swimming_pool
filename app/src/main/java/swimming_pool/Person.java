package swimming_pool;

public class Person{
    private int age;
    private boolean isMenber;
    private String identity;

    public Person(int age, boolean isMenber) throws IllegalArgumentException{
        this.age = age;
        this.isMenber = isMenber;
        this.identity = "Normal";

        ageLimit();
    }

    public Person(int age, boolean isMenber, String identity) throws IllegalArgumentException{
        this.age = age;
        this.isMenber = isMenber;
        this.identity = identity;

        ageLimit();
    }

    public int getAge(){
        return age;
    }


    public boolean isMenber(){
        return isMenber;
    }

    public boolean isCoach(){
        return identity.equals("Coach");
    }

    public boolean isStudent(){
        return identity.equals("Student");
    }

    public boolean isConcession(){
        return age <= 12 || age >= 60;
    }

    public void ageLimit() throws IllegalArgumentException{
        if(age < 3 || age > 75){
            throw new IllegalArgumentException("Age too big or too small.");
        }
    }

    
}
