package io.wisoft.dao;

import io.wisoft.connection.DbConnection;
import io.wisoft.vo.Panel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PanelDao {
  SqlSessionFactory sqlSessionFactory = DbConnection.getInstance();
  List<Panel> panelList = new ArrayList<>();
  Panel panel = new Panel();
  int result = 0;

  public List selectPanels() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final PanelMapperDao panelMapperDao = sqlSession.getMapper(PanelMapperDao.class);
      panelList = panelMapperDao.selectPanels();
    } catch (Exception e) {
      System.out.println(e);
    }
    return panelList;
  }

  public List<Panel> selectPanelsWithAccountNo(int accountNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final PanelMapperDao panelMapperDao = sqlSession.getMapper(PanelMapperDao.class);
      panelList = panelMapperDao.selectPanelsWithAccountNo(accountNo);

    } catch (Exception e) {
      System.out.println(e);
    }
    return panelList;
  }

  public Panel selectPanel(final Long panelNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final PanelMapperDao panelMapperDao = sqlSession.getMapper(PanelMapperDao.class);
      panel = panelMapperDao.selectPanel(panelNo);
    } catch (Exception e) {
      System.out.println(e);
    }
    return panel;
  }

  public int insertPanel(final Panel panel) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final PanelMapperDao panelMapperDao = sqlSession.getMapper(PanelMapperDao.class);
      result = panelMapperDao.insertPanel(panel);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }

  public int updatePanel(final Panel panel) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final PanelMapperDao panelMapperDao = sqlSession.getMapper(PanelMapperDao.class);
      result = panelMapperDao.updatePanel(panel);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }

  public int deletePanel(final Long panelNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final PanelMapperDao panelMapperDao = sqlSession.getMapper(PanelMapperDao.class);
      result = panelMapperDao.deletePanel(panelNo);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }
}
