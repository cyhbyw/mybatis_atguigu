package com.atguigu.mybatis.dao;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.CYHPair;

public interface EmployeeMapper {

    /**
     * 自定义的 CYHPair
     * 没有实现 Map.Entry，可以正常工作
     * @param list
     * @return
     */
    int updateByCYHPair(@Param("list") List<CYHPair<Integer, String>> list);

    /**
     * Apache Commons Pair 实现了 Map.Entry，不能正常工作
     * @param list
     * @return
     */
    int updateByApacheCommonsPair(@Param("list") List<Pair<Integer, String>> list);

}
