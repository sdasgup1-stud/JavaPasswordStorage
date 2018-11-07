public class User{

    private String username;
    private String hashed_password;
    private int income;

    User(){}

    User(String name, int income){
        this.username = name;
        this.income = income;
    }

    private store_password(String password_hash){
        this.hashed_password = password_hash;
    }

    public void generate_password(String password){
        this.store_password(Password.getSaltedHash(password));
    }

    int unlock_income(String username, String cleartext_password){
        if(Password.check(cleartext_password, this.hashed_password)){
            return this.income;
        } else {
            System.out.println("Passwort does not match stored hash for user");
            return null;
        }
        
    }

}