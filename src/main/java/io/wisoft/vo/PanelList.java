package io.wisoft.vo;

public class PanelList {
  private Long panelNo;
  private String panelId;
  private String name;
  private String location;

  public PanelList(String panelId, String name, String location) {
    this.panelId = panelId;
    this.name = name;
    this.location = location;
  }

  public PanelList() {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}
