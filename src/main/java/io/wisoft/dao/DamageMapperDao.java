package io.wisoft.dao;

import io.wisoft.vo.Damage;

import java.util.List;

public interface DamageMapperDao {
  List<Damage> selectDamages(Long panelNo) throws Exception;
  Damage selectDamage(Long damageNo) throws Exception;
  int insertDamage(Damage damage) throws Exception;
  int updateDamage(Damage damage) throws Exception;
  int deleteDamage(Long damageNo) throws Exception;
}
