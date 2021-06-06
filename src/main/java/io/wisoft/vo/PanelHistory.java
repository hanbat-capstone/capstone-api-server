package io.wisoft.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PanelHistory {
  private String name;
  private Long historyNo;
  private Long panelNo;
  private double expectCurrent;
  private double actualCurrent;
  private Timestamp time;
  private String location;


  public PanelHistory(String location, String name, Long historyNo, Long panelNo, double expectCurrent, double actualCurrent, Timestamp time) {
    this.name = name;
    this.historyNo = historyNo;
    this.panelNo = panelNo;
    this.expectCurrent = expectCurrent;
    this.actualCurrent = actualCurrent;
    this.time = time;
    this.location = location;

  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public Long getHistoryNo() {
    return historyNo;
  }

  public void setHistoryNo(Long historyNo) {
    this.historyNo = historyNo;
  }

  public PanelHistory() {
  }

  public Long getPanelNo() {
    return panelNo;
  }

  public void setPanelNo(Long panelNo) {
    this.panelNo = panelNo;
  }

  public double getExpectCurrent() {
    return expectCurrent;
  }

  public void setExpectCurrent(double expectCurrent) {
    this.expectCurrent = expectCurrent;
  }

  public double getActualCurrent() {
    return actualCurrent;
  }

  public void setActualCurrent(double actualCurrent) {
    this.actualCurrent = actualCurrent;
  }
}
