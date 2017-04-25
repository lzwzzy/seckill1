package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.SeckillException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lzw on 2017/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
        /**
         * list=[Seckill{seckillId=1000, name='1000元秒杀iphone7', number=100, startTime=Thu Apr 20 00:00:00 CST 2017, endTime=Fri Apr 21 00:00:00 CST 2017, createTime=Mon Apr 17 21:58:43 CST 2017},
         * Seckill{seckillId=1001, name='500元秒杀ipad4', number=200, startTime=Thu Apr 20 00:00:00 CST 2017, endTime=Fri Apr 21 00:00:00 CST 2017, createTime=Mon Apr 17 21:58:43 CST 2017},
         * Seckill{seckillId=1002, name='300元秒杀小米6', number=300, startTime=Thu Apr 20 00:00:00 CST 2017, endTime=Fri Apr 21 00:00:00 CST 2017, createTime=Mon Apr 17 21:58:43 CST 2017},
         * Seckill{seckillId=1003, name='200元秒杀红米note4', number=400, startTime=Thu Apr 20 00:00:00 CST 2017, endTime=Fri Apr 21 00:00:00 CST 2017, createTime=Mon Apr 17 21:58:43 CST 2017}]
         */
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    /**
     * 集成测试代码完整逻辑，注意可重复执行
     *
     * @throws Exception
     */
    @Test
    public void exportSeckillLogic() throws Exception {

        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);

        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long userphone = 18840810323L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, userphone, md5);
                logger.info("execution={}", execution);
            } catch (SeckillException e) {
                logger.error(e.getMessage());
            } catch (RuntimeException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
    }

    @Test
    public void executeSeckillProcedure() throws Exception {
        long seckillId = 1003;
        long phone = 18933337890L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }


}