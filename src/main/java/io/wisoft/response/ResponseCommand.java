package io.wisoft.response;

import org.json.JSONObject;

@SuppressWarnings("ALL")
public class ResponseCommand {

  public String getInsertCommand(){
    JSONObject insert = new JSONObject();
    insert.put("message" , "삽입이 완료되었습니다.");

    return insert.toString();
  }

  public String getUpdateCommand(){
    JSONObject update = new JSONObject();
    update.put("massage", "수정이 완료되었습니다.");

    return update.toString();
  }

  public String getDeleteCommand(){
    JSONObject delete = new JSONObject();
    delete.put("message", "삭제가 완료되었습니다.");

    return delete.toString();
  }

  public String getNoContent(){
    JSONObject noContent = new JSONObject();
    noContent.put("message", "해당하는 정보를 찾을 수 없습니다.");

    return noContent.toString();
  }

  public String getForbidden(){
    JSONObject forbidden = new JSONObject();
    forbidden.put("message", "원하시는 요청을 처리할 수 없습니다.");

    return forbidden.toString();
  }

  public String getTest(){
    JSONObject noContent = new JSONObject();
    noContent.put("message", "test");

    return noContent.toString();
  }
}
