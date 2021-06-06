package io.wisoft.connection;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

@Slf4j
public class DbConnection {
  private static final String MYBATIS_CONFIG_FILE = "mybatis/mybatis-config.xml";
  private static SqlSessionFactory sqlSessionFactory;

  public static SqlSessionFactory getInstance() {
    if (sqlSessionFactory == null) {
      try (final Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG_FILE)) {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
      } catch (final IOException e) {
      }
    }
    return sqlSessionFactory;
  }

}
