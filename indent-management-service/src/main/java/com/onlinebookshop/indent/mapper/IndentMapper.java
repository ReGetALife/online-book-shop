package com.onlinebookshop.indent.mapper;

import com.onlinebookshop.indent.entity.Indent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IndentMapper {
    //查看个人订单
    @Select("select * from indent where account_id=#{account_id}")
    List<Indent> getIndent(@Param(value = "account_id")Long account_id);

}
