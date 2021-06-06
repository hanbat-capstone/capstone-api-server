package io.wisoft.vo;

public class Account {
  private int accountNo;
  private String accountId;
  private String name;
  private String email;
  private String password;
  private String phoneNumber;
  private String location;

  public Account(String accountId, String name, String email, String password, String phoneNumber ,String location) {
    this.accountId = accountId;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(int accountNo) {
    this.accountNo = accountNo;
  }

  public Account() {
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Account{" +
      "accountId=" + accountId +
      ", name='" + name + '\'' +
      ", email'" + email + '\'' +
      ", phoneNumber'" + phoneNumber + '\'' +
      '}';
  }
}
