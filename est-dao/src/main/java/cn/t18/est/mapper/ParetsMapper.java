package cn.t18.est.mapper;

import cn.t18.est.pojo.Parets;

/**
 * @Entity cn.t18.est.pojo.Parets
 */
public interface ParetsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Parets record);

    int insertSelective(Parets record);

    Parets selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Parets record);

    int updateByPrimaryKey(Parets record);

}
