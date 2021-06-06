package io.wisoft.dao;

import io.wisoft.connection.DbConnection;
import io.wisoft.vo.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {
  SqlSessionFactory sqlSessionFactory = DbConnection.getInstance(); //sql을 실행할 때 사용할 도구를 만들어 준다.
  List<Account> accountList = new ArrayList<>();
  Account account = new Account();
  int result = 0;

  public List<Account> selectAccounts() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final AccountMapperDao accountMapperDao = sqlSession.getMapper(AccountMapperDao.class);
      accountList = accountMapperDao.selectAccounts();
    } catch (Exception e) {
      System.out.println(e);
    }
    return accountList;
  }

  public Account selectAccountInformation(final Long panelNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final AccountMapperDao accountMapperDao = sqlSession.getMapper(AccountMapperDao.class);
      account = accountMapperDao.selectAccountInformation(panelNo);
      System.out.println();
      System.out.println("오류 발생 지역: "+account.getLocation());
      System.out.println("고객명: "+account.getPhoneNumber());
      System.out.println("고객 번호: "+account.getLocation());

    } catch (Exception e) {
      System.out.println(e);
    }
    return account;
  }

  public Account selectAccount(final int accountNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final AccountMapperDao accountMapperDao = sqlSession.getMapper(AccountMapperDao.class);
      account = accountMapperDao.selectAccount(accountNo);
    } catch (Exception e) {
      System.out.println(e);
    }
    return account;
  }

  public int insertAccount(final Account account) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final AccountMapperDao accountMapperDao = sqlSession.getMapper(AccountMapperDao.class);
      result = accountMapperDao.insertAccount(account);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }

  public int updateAccount(final Account account) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      final AccountMapperDao accountMapperDao = sqlSession.getMapper(AccountMapperDao.class);
      result = accountMapperDao.updateAccount(account);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }

  public int deleteAccount(final int accountNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      final AccountMapperDao accountMapperDao = sqlSession.getMapper(AccountMapperDao.class);
      result = accountMapperDao.deleteAccount(accountNo);
      sqlSession.commit();
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }
}
