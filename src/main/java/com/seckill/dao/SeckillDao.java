package com.seckill.dao;

import com.seckill.entity.Seckill;
import com.seckill.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lzw on 2017/4/17.
 */
public interface SeckillDao {
    /**
     * 减库存，
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killProcedure(Map<String,Object> paramMap);


    User queryUser(@Param("username") String username, @Param("password") String password);
}
