package swimming_pool;

public class Person{
    private int age;
    private boolean is_menber;
    private boolean is_group;
    private String identity;

    public Person(int age, boolean is_menber, boolean is_group) throws IllegalArgumentException{
        this.age = age;
        this.is_menber = is_menber;
        this.identity = null;

        age_limit();
    }

    public Person(int age, boolean is_menber, boolean is_group, String identity) throws IllegalArgumentException{
        this.age = age;
        this.is_menber = is_menber;
        this.identity = identity;

        age_limit();
    }

    public int get_age(){
        return age;
    }


    public boolean is_menber(){
        return is_menber;
    }

    public boolean is_coach(){
        return identity.equals("Coach");
    }

    public boolean is_student(){
        return identity.equals("Student");
    }

    public boolean is_concession(){
        return age <= 12 || age >= 60;
    }

    public void age_limit() throws IllegalArgumentException{
        if(age < 3 || age > 75){
            throw new IllegalArgumentException("Age too big or too small.");
        }
    }

    
}
