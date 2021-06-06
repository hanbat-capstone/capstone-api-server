package io.wisoft.controller;

import io.wisoft.dao.AccountDao;
import io.wisoft.dao.CollectorDao;
import io.wisoft.dao.PanelDao;
import io.wisoft.response.ResponseCommand;
import io.wisoft.vo.Account;
import io.wisoft.vo.Collector;
import io.wisoft.vo.Panel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("api/accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController extends ResponseCommand {
  final AccountDao accountDao = new AccountDao();
  final PanelDao panelDao = new PanelDao();
  final CollectorDao collectorDao = new CollectorDao();
  List<Account> accountList = new ArrayList<>();
  List<Panel> panelList;
  List<Collector> collectorList;
  Account account = new Account();

  @GET
  public Response selectAccounts() {
    accountList = accountDao.selectAccounts();

    if (accountList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
        .entity(getNoContent())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }

    return Response.ok()
      .entity(accountList)
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }

  @Path("/{account-no}")
  @GET
  public Response selectAccount(@PathParam("account-no") final int accountNo) {
    account = accountDao.selectAccount(accountNo);

    if (account == null) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }
    return Response.status(Response.Status.OK)
      .entity(account)
      .build();
  }

  @Path("/{account-no}/panels")
  @GET
  public Response selectPanelWithAccountNo(@PathParam("account-no") final int accountNo) {
    panelList = panelDao.selectPanelsWithAccountNo(accountNo);

    if (panelList.isEmpty()) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }

    return Response.status(Response.Status.OK)
      .entity(panelList)
      .build();
  }

  @Path("/{account-no}/collectors")
  @GET
  public Response selectCollectorsWithAccountNo(@PathParam("account-no") final int accountNo){
    collectorList = collectorDao.selectCollectorsWithAccountNo(accountNo);

    if (collectorList.isEmpty()) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }

    return Response.status(Response.Status.OK)
      .entity(collectorList)
      .build();
  }

  @Path("/{account-no}/panels/{panel-no}/collectors")
  @GET
  public Response selectCollectorsWithAccountNoAndPanelNo(@PathParam("account-no") final int accountNo, @PathParam("panel-no") final Long panelNo){
    collectorList = collectorDao.selectCollectorsWithAccountNoAndPanelNo(accountNo, panelNo);

    if (collectorList.isEmpty()) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }

    return Response.status(Response.Status.OK)
      .entity(collectorList)
      .build();
  }

  @Path("/{account-no}/panels/{panel-no}/collectors/latest")
  @GET
  public Response selectLatestCollectorsWithAccountNoAndPanelNo(@PathParam("account-no") final int accountNo, @PathParam("panel-no") final Long panelNo){
    collectorList = collectorDao.selectLatestCollectorsWithAccountNoAndPanelNo(accountNo, panelNo);

    if (collectorList.isEmpty()) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
        .build();
    }

    return Response.status(Response.Status.OK)
      .entity(collectorList)
      .build();
  }

  @POST
  public Response insertAccount(final Account account) {
    System.out.println("들어옴");
    int result = accountDao.insertAccount(account);
    System.out.println(result);
    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }
    return Response.status(Response.Status.OK)
      .entity(getInsertCommand())
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }

  @Path("/{account-no}")
  @PUT
  public Response updateAccount(@PathParam("account-no") final int accountNo, final Account account) {
    account.setAccountNo(accountNo);
    int result = accountDao.updateAccount(account);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .entity(getUpdateCommand())
      .build();
  }

  @Path("/{account-no}")
  @DELETE
  public Response deleteAccount(@PathParam("account-no") final int accountNo) {
    int result = accountDao.deleteAccount(accountNo);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }
    return Response.status(Response.Status.OK)
      .entity(getDeleteCommand())
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }
}
