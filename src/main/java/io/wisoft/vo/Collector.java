package io.wisoft.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Collector {
  private String name;
  private Long collectorNo;
  private Long panelNo;
  private double sensorIrradiation; //BigDecimal 타입은 실수 계산에 있어서 오차를 줄여준다.
  private double panelIrradiation;
  private double temperature;
  private Timestamp time;
  private String location;

  public Collector(Long collectorNo, Long panelNo, double sensorIrradiation, double panelIrradiation, Timestamp time) {
    this.collectorNo = collectorNo;
    this.panelNo = panelNo;
    this.panelIrradiation = panelIrradiation;
    this.sensorIrradiation = sensorIrradiation;
  }

  public Collector(Long panelNo, double sensorIrradiation, double panelIrradiation, Timestamp time) {
    this.panelNo = panelNo;
    this.panelIrradiation = panelIrradiation;
    this.sensorIrradiation = sensorIrradiation;
  }

  public Collector() {
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

  public Long getCollectorNo() {
    return collectorNo;
  }

  public void setCollectorNo(Long collectorNo) {
    this.collectorNo = collectorNo;
  }

  public Long getPanelNo() {
    return panelNo;
  }

  public void setPanelNo(Long panelNo) {
    this.panelNo = panelNo;
  }

  public double getSensorIrradiation() {
    return sensorIrradiation;
  }

  public void setSensorIrradiation(double sensorIrradiation) {
    this.sensorIrradiation = sensorIrradiation;
  }

  public double getPanelIrradiation() {
    return panelIrradiation;
  }

  public void setPanelIrradiation(double panelIrradiation) {
    this.panelIrradiation = panelIrradiation;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
