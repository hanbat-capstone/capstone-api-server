package io.wisoft.vo;

import java.sql.Timestamp;

public class Damage {
  private String name;
  private Long damageNo;
  private Long panelNo;
  private String panelCodeNo;
  private String description;
  private Timestamp time;
  private String location;

  public Damage(String name, Long damageNo, Long panelNo, String panelCodeNo, String description, Timestamp time, String location) {
    this.name = name;
    this.damageNo = damageNo;
    this.panelNo = panelNo;
    this.panelCodeNo = panelCodeNo;
    this.description = description;
    this.time = time;
    this.location = location;
  }

  public Damage() {
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

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public Long getDamageNo() {
    return damageNo;
  }

  public void setDamageNo(Long damageNo) {
    this.damageNo = damageNo;
  }

  public Long getPanelNo() {
    return panelNo;
  }

  public void setPanelNo(Long panelNo) {
    this.panelNo = panelNo;
  }

  public String getPanelCodeNo() {
    return panelCodeNo;
  }

  public void setPanelCodeNo(String panelCodeNo) {
    this.panelCodeNo = panelCodeNo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
