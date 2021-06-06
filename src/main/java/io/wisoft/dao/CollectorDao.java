package io.wisoft.dao;

import io.wisoft.connection.DbConnection;
import io.wisoft.vo.Account;
import io.wisoft.vo.Collector;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CollectorDao {
  List<Collector> collectorList = new ArrayList<>();
  HashMap<String, Object> hm = new HashMap<>();
  int result;
  SqlSessionFactory sqlSessionFactory = DbConnection.getInstance();

  public int insertCollector(final Collector collector) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      CollectorMapperDao deviceMapperDao = sqlSession.getMapper(CollectorMapperDao.class);
      result = deviceMapperDao.insertCollector(collector);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }

  public List<Collector> selectAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final CollectorMapperDao collectorMapperDao = sqlSession.getMapper(CollectorMapperDao.class);
      collectorList = collectorMapperDao.selectAll();
    } catch (Exception e) {
      System.out.println(e);
    }
    return collectorList;
  }

  public List<Collector> selectCollectorsWithAccountNo(final int accountNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final CollectorMapperDao collectorMapperDao = sqlSession.getMapper(CollectorMapperDao.class);
      collectorList = collectorMapperDao.selectCollectorsWithAccountNo(accountNo);
    } catch (Exception e) {
      System.out.println(e);
    }
    return collectorList;
  }

  public List<Collector> selectCollectorsWithAccountNoAndPanelNo(final int accountNo, final Long panelNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      hm.put("accountNo", accountNo);
      hm.put("panelNo", panelNo);
      final CollectorMapperDao collectorMapperDao = sqlSession.getMapper(CollectorMapperDao.class);
      collectorList = collectorMapperDao.selectCollectorsWithAccountNoAndPanelNo(hm);
    } catch (Exception e) {
      System.out.println(e);
    }
    return collectorList;
  }

  public List<Collector> selectLatestCollectorsWithAccountNoAndPanelNo(final int accountNo, final Long panelNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      hm.put("accountNo", accountNo);
      hm.put("panelNo", panelNo);
      final CollectorMapperDao collectorMapperDao = sqlSession.getMapper(CollectorMapperDao.class);
      collectorList = collectorMapperDao.selectLatestCollectorsWithAccountNoAndPanelNo(hm);
    } catch (Exception e) {
      System.out.println(e);
    }
    return collectorList;
  }

  public List<Collector> selectCollectorsWithPanelNo(final Long panelNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final CollectorMapperDao collectorMapperDao = sqlSession.getMapper(CollectorMapperDao.class);
      collectorList = collectorMapperDao.selectCollectorsWithPanelNo(panelNo);
    } catch (Exception e) {
      System.out.println(e);
    }
    return collectorList;
  }
}
