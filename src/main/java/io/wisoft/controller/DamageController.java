package io.wisoft.controller;

import io.wisoft.dao.DamageDao;
import io.wisoft.response.ResponseCommand;
import io.wisoft.vo.Damage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("api/damages/{panel-no}")
public class DamageController extends ResponseCommand {
  List<Damage> damageList = new ArrayList<>();
  Damage damage = new Damage();
  DamageDao damageDao = new DamageDao();
  int result = 0;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectDamages(@PathParam("panel-no") final Long panelNo){
    damageList = damageDao.selectDamages(panelNo);

    if (damageList.isEmpty()) {
      return Response.status(Response.Status.NO_CONTENT)
        .entity(getNoContent())
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
        .build();
    }

    return Response.ok()
      .entity(damageList)
      .header("Access-Control-Allow-Origin", "*")
      .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
      .allow("OPTIONS")
      .build();
  }

  @Path("/{panel-no}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response selectDamage(@PathParam("panel-no") final Long panelNo){
    damage = damageDao.selectDamage(panelNo);

    if (damage == null){
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getNoContent())
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
          .allow("OPTIONS")

        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(damage)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
        .allow("OPTIONS")
      .build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response insertDamage(Damage damage){
    result = damageDao.insertDamage(damage);

    if (result == 0){
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(getInsertCommand())
      .build();
  }

  @Path("/{damage-no}")
  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateDamage(@PathParam("damage-no") final Long damageNo, Damage damage){
    damage.setDamageNo(damageNo);
    result = damageDao.updateDamage(damage);

    if (result == 0){
      return Response.status(Response.Status.FORBIDDEN)
        .entity(getForbidden())
        .build();
    }
    return Response.status(Response.Status.OK)
      .type(MediaType.APPLICATION_JSON)
      .entity(getUpdateCommand())
      .build();
  }

  @Path("/{damage-no}")
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteDamage(@PathParam("damage-no") final Long damageNo){
    result = damageDao.deleteDamage(damageNo);

    if (result == 0){
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
