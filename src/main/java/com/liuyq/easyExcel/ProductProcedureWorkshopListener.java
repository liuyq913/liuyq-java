package com.liuyq.easyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuyuqing
 * @Date: 2019-12-05 17:15
 * @Description:
 */
// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
public class ProductProcedureWorkshopListener extends AnalysisEventListener<ProductProcedureWorkshop> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductProcedureWorkshopListener.class);


    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 3000;
    List<ProductProcedureWorkshop> list = new ArrayList<ProductProcedureWorkshop>();

    /**
     * 这个每一条数据解析都会来调用
     * <p>
     * one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     */
    @Override
    public void invoke(ProductProcedureWorkshop productProcedureWorkshop, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(productProcedureWorkshop));



    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //最后来保存
        LOGGER.info("所有数据解析完成！");
    }


    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        //保存数据
        LOGGER.info("存储数据库成功！");
    }
}
