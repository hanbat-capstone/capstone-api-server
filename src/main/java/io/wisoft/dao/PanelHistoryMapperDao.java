package io.wisoft.dao;

import io.wisoft.vo.PanelHistory;

import java.util.List;

public interface PanelHistoryMapperDao {
  List<PanelHistory> selectsPanelHistory() throws Exception;
  List<PanelHistory> selectPanelHistory(final Long historyNo) throws Exception;
  int selectCount(final Long panelNo) throws Exception;
  int insertPanelHistory(final PanelHistory panelHistory) throws Exception;
  int updatePanelHistory(final PanelHistory panelHistory) throws Exception;
  int deletePanelHistory(final Long historyNo) throws Exception;
}
