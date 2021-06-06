package io.wisoft.controller;


import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import io.wisoft.dao.AccountDao;
import io.wisoft.dao.CollectorDao;
import io.wisoft.dao.PanelDao;
import io.wisoft.dao.PanelHistoryDao;
import io.wisoft.response.ResponseCommand;
import io.wisoft.vo.Account;
import io.wisoft.vo.Collector;
import io.wisoft.vo.Panel;
import io.wisoft.vo.PanelHistory;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("api/panels")
public class PanelController extends ResponseCommand {
  PanelDao panelDao = new PanelDao();
  PanelHistoryDao panelHistoryDao = new PanelHistoryDao();
  CollectorDao collectorDao = new CollectorDao();
  List<Collector> collectorList = new ArrayList<>();
  List<Panel> panelList = new ArrayList<>();
  Panel panel = new Panel();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectPanels() {
    panelList = panelDao.selectPanels();

    if (panelList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
        .entity(getNoContent())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }

    return Response.ok()
      .entity(panelList)
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }


  @Path("/{panel-no}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectPanel(@PathParam("panel-no") final Long panelNo) {
    panel = panelDao.selectPanel(panelNo);

    if (panel == null) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(panel)
      .build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertPanel(final Panel panel) {
    int result = panelDao.insertPanel(panel);
    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
          .allow("OPTIONS")
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON_TYPE)
      .entity(getInsertCommand())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
      .build();
  }

  @Path("/{panel-no}")
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateAccount(@PathParam("panel-no") final Long panelNo, final Panel panel) {
    panel.setPanelNo(panelNo);
    int result = panelDao.updatePanel(panel);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON_TYPE)
      .entity(getUpdateCommand())
      .build();
  }

  @Path("/{panel-no}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteAccount(@PathParam("panel-no") final Long panelNo) {
    int result = panelDao.deletePanel(panelNo);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON_TYPE)
      .entity(getDeleteCommand())
      .build();
  }

  @Path("/{panel-no}/collectors")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertCollectors(@PathParam("panel-no") final Long panelNo, final Collector collector) {
    collector.setPanelNo(panelNo);
    System.out.println();
    System.out.print("패널에서 측정된 일사량: ");
    System.out.println(collector.getPanelIrradiation());
    System.out.print("센서에서 측정된 일사량: ");
    System.out.println(collector.getSensorIrradiation());
    double result = ((collector.getSensorIrradiation() - collector.getPanelIrradiation()) / collector.getSensorIrradiation())*100;

    if (result<0)
      result = -result;
    System.out.printf("오차율: %.2f", result);
    System.out.println("%");

    if(result > 40){
      PanelHistory panelHistory = new PanelHistory();
      panelHistory.setActualCurrent(collector.getSensorIrradiation());
      panelHistory.setExpectCurrent(collector.getPanelIrradiation());
      panelHistory.setPanelNo(collector.getPanelNo());
      panelHistoryDao.insertPanelHistory(panelHistory);
      result = panelHistoryDao.selectCount(collector.getPanelNo());
      System.out.println("오류 횟수: "+result+"회");

      if (result==5){
        AccountDao accountDao = new AccountDao();
        Account account = accountDao.selectAccountInformation(panelNo);

        String api_key = "NCSIZ8UFKKGXUPCV";
        String api_secret = "SF8Z3RMVM56LWD9GWIXEKTWKHQI8I5RO";
        Message coolsms = new Message(api_key, api_secret);

        HashMap<String, String> values = new HashMap<>();
        values.put("to", account.getPhoneNumber());
        values.put("from", "01066251025");
        values.put("type", "LMS");
        values.put("text", "\""+account.getLocation()+"\" 에 위치한 \""+account.getName()+"\" 고객님의 태양광 발전지역에 문제가 있는것으로 판별되었습니다. 수리 또는 정밀검사를 원하신다면 연락주세요. -Solar Energy 센터-");
        values.put("app_version", "JAVA SDK v1.2");

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<>();
        params.put("to", "01066251025");
        params.put("from", "01066251025"); // 발신번호
        params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
        params.put("text", "\""+account.getLocation()+"\"에 위치한 \""+account.getName()+"\" 고객님의 태양광 발전지역에 문제가 있는것으로 판별되었습니다. "); // 문자내용
        params.put("app_version", "JAVA SDK v1.2"); // application name and version

        try {
          JSONObject obj1 = (JSONObject) coolsms.send(params);
          JSONObject obj2 = (JSONObject) coolsms.send(values);
          System.out.println(obj1.toString());
          System.out.println(obj2.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
      }
      result = collectorDao.insertCollector(collector);

    }
    else result = collectorDao.insertCollector(collector);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }
    System.out.println("삽입이 완료되었습니다.");
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON_TYPE)
      .entity(getInsertCommand())
      .build();
  }
}
