package io.wisoft.dao;

import io.wisoft.vo.Account;
import io.wisoft.vo.Collector;

import java.util.List;

public interface AccountMapperDao {
  List<Account> selectAccounts() throws Exception;
  Account selectAccountInformation(final Long panelNo) throws Exception;
  Account selectAccount(final int accountNo) throws Exception;
  int insertAccount(final Account account) throws Exception;
  int updateAccount(final Account account) throws Exception;
  int deleteAccount(final int accountNo) throws Exception;
}
