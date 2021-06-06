package io.wisoft.dao;

import io.wisoft.connection.DbConnection;
import io.wisoft.vo.PanelHistory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PanelHistoryDao {
  SqlSessionFactory sqlSessionFactory = DbConnection.getInstance();
  List<PanelHistory> panelHistoryList = new ArrayList<>();
  PanelHistory panelHistory = new PanelHistory();
  int result = 0;

  public List<PanelHistory> selectsPanelHistory() {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      PanelHistoryMapperDao panelHistoryMapperDao = sqlSession.getMapper(PanelHistoryMapperDao.class);
      panelHistoryList = panelHistoryMapperDao.selectsPanelHistory();
    }catch (Exception e){
      System.out.println(e);
    }
    return panelHistoryList;
  }

  public List<PanelHistory> selectPanelHistory(final Long historyNo) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      System.out.println("들어옴");
      PanelHistoryMapperDao panelHistoryMapperDao = sqlSession.getMapper(PanelHistoryMapperDao.class);
      panelHistoryList = panelHistoryMapperDao.selectPanelHistory(historyNo);
      for (PanelHistory panelHistory:panelHistoryList) {
        System.out.println(panelHistory.getExpectCurrent());
        System.out.println(panelHistory.getActualCurrent());
      }

    }catch (Exception e){
      System.out.println(e);
    }
    return panelHistoryList;
  }

  public int selectCount(final Long panelNo) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      PanelHistoryMapperDao panelHistoryMapperDao = sqlSession.getMapper(PanelHistoryMapperDao.class);
      result = panelHistoryMapperDao.selectCount(panelNo);
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

  public int insertPanelHistory(final PanelHistory panelHistory) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      PanelHistoryMapperDao panelHistoryMapperDao = sqlSession.getMapper(PanelHistoryMapperDao.class);
      result = panelHistoryMapperDao.insertPanelHistory(panelHistory);
      sqlSession.commit();
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

  public int updatePanelHistory(final PanelHistory panelHistory) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      PanelHistoryMapperDao panelHistoryMapperDao = sqlSession.getMapper(PanelHistoryMapperDao.class);
      result = panelHistoryMapperDao.updatePanelHistory(panelHistory);
      sqlSession.commit();
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

  public int deletePanelHistory(final Long historyNo) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      PanelHistoryMapperDao panelHistoryMapperDao = sqlSession.getMapper(PanelHistoryMapperDao.class);
      result = panelHistoryMapperDao.deletePanelHistory(historyNo);
      sqlSession.commit();
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }
}
