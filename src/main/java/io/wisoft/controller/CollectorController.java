package io.wisoft.controller;

import io.wisoft.dao.AccountDao;
import io.wisoft.dao.CollectorDao;
import io.wisoft.response.ResponseCommand;
import io.wisoft.vo.Account;
import io.wisoft.vo.Collector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class CollectorController extends ResponseCommand {
  final CollectorDao collectorDao = new CollectorDao();
  final AccountDao accountDao = new AccountDao();
  Account account = new Account();
  List<Collector> collectorList = new ArrayList<>();
  List<Account> accountList = new ArrayList<>();

  @Path("/collectors")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectCollectors() {
    collectorList = collectorDao.selectAll();

    if (collectorList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
        .entity(getNoContent())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }

    return Response.ok()
      .entity(collectorList)
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }

  @Path("/collectors/{panel-no}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectCollectorsWithPanelNo(@PathParam("panel-no") Long panelNo) {
    collectorList = collectorDao.selectCollectorsWithPanelNo(panelNo);

    if (collectorList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
        .entity(getNoContent())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }

    return Response.ok()
      .entity(collectorList)
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }

//  @Path("/accounts/information/{panel-no}")
//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//  public Response selectAccountInformation(@PathParam("panel-no") final Long panelNo) {
//    System.out.println("test1");
//    account = accountDao.selectAccountInformation(panelNo);
//    System.out.println("test3");
//
//    if (accountList.isEmpty()) {
//      System.out.println("비어 있음");
//      return Response.status(Response.Status.NO_CONTENT)
//        .entity(getNoContent())
//        .header("Access-Control-Allow-Origin", "*")
//        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//        .allow("OPTIONS")
//        .build();
//    }
//
//    System.out.println("비어 있지 않음");
//    return Response.ok()
//      .entity(accountList)
//      .header("Access-Control-Allow-Origin", "*")
//      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//      .allow("OPTIONS")
//      .build();
//  }

}

