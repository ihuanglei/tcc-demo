/*
 * Copyright (c) huanglei.org All Rights Reserved.
 * @author: huanglei
 * @date: 3/13/20, 12:28 AM
 * @version: 1.0
 */

package org.huanglei.tcc.demo.dao;

import org.apache.ibatis.annotations.*;
import org.huanglei.tcc.demo.entity.PayRecordEntity;
import org.huanglei.tcc.demo.common.PayStatus;

import java.util.List;
import java.util.Map;

@Mapper
public interface PayRecordMapper {

    @Insert("INSERT INTO PAY_RECORD(pay_no,order_no,product_name,price,pri1,pri2,status,create_time,update_time)" +
            "VALUES(#{payNo},#{orderNo},#{productName},#{price},#{pri1},#{pri2},#{status},#{createTime},#{updateTime})")
    void addPayRecord(PayRecordEntity entity);


    @Select("SELECT * FROM PAY_RECORD WHERE order_no = #{orderNo}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "pay_no", property = "payNo"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "price", property = "price"),
            @Result(column = "pri1", property = "pri1"),
            @Result(column = "pri2", property = "pri2"),
            @Result(column = "memo", property = "memo"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
            @Result(column = "status", property = "status"),
    })
    List<PayRecordEntity> getPayRecordList(Map<String, Object> params);

    @Update("UPDATE PAY_RECORD SET status = #{status.value} WHERE pay_no = #{payNo}")
    void setPayStatus(@Param("payNo") Long payNo,@Param("status") PayStatus payStatus);

}
