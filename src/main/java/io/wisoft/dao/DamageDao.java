package io.wisoft.dao;

import io.wisoft.connection.DbConnection;
import io.wisoft.vo.Damage;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DamageDao {
  SqlSessionFactory sqlSessionFactory = DbConnection.getInstance();
  List<Damage> damageList = new ArrayList<>();
  Damage damage = new Damage();
  int result = 0;

  public List<Damage> selectDamages(Long panelNo) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      DamageMapperDao damageMapperDao = sqlSession.getMapper(DamageMapperDao.class);
      damageList = damageMapperDao.selectDamages(panelNo);
    }catch (Exception e){
      System.out.println(e);
    }
    return damageList;
  }

  public Damage selectDamage(Long damageNo) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      DamageMapperDao damageMapperDao = sqlSession.getMapper(DamageMapperDao.class);
      damage = damageMapperDao.selectDamage(damageNo);
    }catch (Exception e){
      System.out.println(e);
    }
    return damage;
  }

  public int insertDamage(Damage damage) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      DamageMapperDao damageMapperDao = sqlSession.getMapper(DamageMapperDao.class);
      result = damageMapperDao.insertDamage(damage);
      sqlSession.commit();
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

  public int updateDamage(Damage damage) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      DamageMapperDao damageMapperDao = sqlSession.getMapper(DamageMapperDao.class);
      result = damageMapperDao.updateDamage(damage);
      sqlSession.commit();
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

  public int deleteDamage(Long damageNo) {
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      DamageMapperDao damageMapperDao = sqlSession.getMapper(DamageMapperDao.class);
      result = damageMapperDao.deleteDamage(damageNo);
      sqlSession.commit();
    }catch (Exception e){
      System.out.println(e);
    }
    return result;
  }

}
