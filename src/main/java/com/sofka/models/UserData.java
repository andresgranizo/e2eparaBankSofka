package com.sofka.models;

public class UserData {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;
    private String username;
    private String password;

    public UserData() {
    }

    public static UserDataBuilder builder() {
        return new UserDataBuilder();
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getPhone() { return phone; }
    public String getSsn() { return ssn; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setSsn(String ssn) { this.ssn = ssn; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    public static class UserDataBuilder {
        private final UserData userData = new UserData();

        public UserDataBuilder firstName(String firstName) {
            userData.setFirstName(firstName);
            return this;
        }

        public UserDataBuilder lastName(String lastName) {
            userData.setLastName(lastName);
            return this;
        }

        public UserDataBuilder address(String address) {
            userData.setAddress(address);
            return this;
        }

        public UserDataBuilder city(String city) {
            userData.setCity(city);
            return this;
        }

        public UserDataBuilder state(String state) {
            userData.setState(state);
            return this;
        }

        public UserDataBuilder zipCode(String zipCode) {
            userData.setZipCode(zipCode);
            return this;
        }

        public UserDataBuilder phone(String phone) {
            userData.setPhone(phone);
            return this;
        }

        public UserDataBuilder ssn(String ssn) {
            userData.setSsn(ssn);
            return this;
        }

        public UserDataBuilder username(String username) {
            userData.setUsername(username);
            return this;
        }

        public UserDataBuilder password(String password) {
            userData.setPassword(password);
            return this;
        }

        public UserData build() {
            return userData;
        }
    }
}
