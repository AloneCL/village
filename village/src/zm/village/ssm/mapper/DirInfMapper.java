package zm.village.ssm.mapper;

import zm.village.dao.DirInf;

public interface DirInfMapper {
    int deleteByPrimaryKey(Integer dirId);

    int insert(DirInf record);

    int insertSelective(DirInf record);

    DirInf selectByPrimaryKey(Integer dirId);

    int updateByPrimaryKeySelective(DirInf record);

    int updateByPrimaryKeyWithBLOBs(DirInf record);

    int updateByPrimaryKey(DirInf record);
}