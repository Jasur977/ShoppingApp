public class User {
    private String userName;
    private String email;

    public User(){
        this.userName = "Jasur";
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void displayUserInfo(){
            System.out.println("User Name: " + userName);
    }


}
