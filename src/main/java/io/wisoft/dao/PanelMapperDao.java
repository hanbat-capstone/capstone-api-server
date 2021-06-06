package io.wisoft.dao;

import io.wisoft.vo.Panel;

import java.util.List;

public interface PanelMapperDao {
  List<Panel> selectPanels() throws Exception;
  List<Panel> selectPanelsWithAccountNo(int accountNo) throws Exception;
  Panel selectPanel(final Long panelNo) throws Exception;
  int insertPanel(final Panel panel) throws Exception;
  int updatePanel(final Panel panel) throws Exception;
  int deletePanel(final Long panelNo) throws Exception;
}
