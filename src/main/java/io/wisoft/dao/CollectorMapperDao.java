package io.wisoft.dao;

import io.wisoft.vo.Collector;

import java.util.HashMap;
import java.util.List;

public interface CollectorMapperDao {
  List<Collector> selectAll() throws Exception;

  List<Collector> selectCollectorsWithAccountNo(final int accountNo) throws Exception;

  List<Collector> selectCollectorsWithAccountNoAndPanelNo(HashMap<String, Object> map) throws Exception;

  List<Collector> selectLatestCollectorsWithAccountNoAndPanelNo(HashMap<String, Object> map) throws Exception;

  List<Collector> selectCollectorsWithPanelNo(final Long panelNo) throws Exception;

  int insertCollector(final Collector collector) throws Exception;


}
