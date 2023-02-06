
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName == null || firstName.isEmpty()) {

        }else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName == null || lastName.isEmpty()){

        }else {
            if (!this.firstName.equals("")) {
                this.lastName = " " + lastName;
            }else {
                this.lastName = lastName;
            }
        }
    }

    public String getFullName() {
        if(this.firstName.equals("") && this.lastName.equals("")) {
            return "Unknown";
        }else {
            return this.firstName + this.lastName;
        }
    }
}