package io.wisoft.controller;

import io.wisoft.dao.PanelHistoryDao;
import io.wisoft.response.ResponseCommand;
import io.wisoft.vo.PanelHistory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("api/panel-history")
public class PanelHistoryController extends ResponseCommand {
  List<PanelHistory> panelHistoryList = new ArrayList<>();
  PanelHistory panelHistory = new PanelHistory();
  PanelHistoryDao panelHistoryDao = new PanelHistoryDao();
  int result = 0;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectsPanelHistory() {
    panelHistoryList = panelHistoryDao.selectsPanelHistory();

    if (panelHistoryList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
        .entity(getNoContent())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }

    return Response.ok()
      .entity(panelHistoryList)
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();

  }

  @Path("/{history-no}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectPanelHistory(@PathParam("history-no") Long historyNo) {
    panelHistoryList = panelHistoryDao.selectPanelHistory(historyNo);

    if (panelHistoryList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
          .entity(getNoContent())
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
          .allow("OPTIONS")
          .build();
    }

    return Response.ok()
        .entity(panelHistoryList)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertPanelHistory(PanelHistory panelHistory) {
    result = panelHistoryDao.insertPanelHistory(panelHistory);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(getInsertCommand())
      .build();
  }

  @Path("/{history-no}")
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  public Response updatePanelHistory(@PathParam("history-no") Long historyNo, PanelHistory panelHistory) {
    panelHistory.setHistoryNo(historyNo);
    result = panelHistoryDao.updatePanelHistory(panelHistory);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(getUpdateCommand())
      .build();
  }

  @Path("/{history-no}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public Response deletePanelHistory(@PathParam("history-no") Long historyNo) {
    result = panelHistoryDao.deletePanelHistory(historyNo);

    if (result == 0) {
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(getDeleteCommand())
      .build();
  }
}
