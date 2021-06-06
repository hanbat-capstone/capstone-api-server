package io.wisoft.vo;

public class Panel {
  private String name;
  private Long panelNo;
  private String panelId;
  private int accountNo;
  private String location;

  public Panel(String panelId, int accountNo, String location, String name) {
    this.panelId = panelId;
    this.accountNo = accountNo;
    this.location = location;
    this.name = name;
  }

  public Panel() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPanelNo() {
    return panelNo;
  }

  public void setPanelNo(Long panelNo) {
    this.panelNo = panelNo;
  }

  public String getPanelId() {
    return panelId;
  }

  public void setPanelId(String panelId) {
    this.panelId = panelId;
  }

  public int getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(int accountNo) {
    this.accountNo = accountNo;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


}
