package cn.mateworks.essample.util;

import cn.mateworks.essample.model.PmcCellLteMin;

import java.io.IOException;

/**
 * Created by James Cheung on 2017/7/24.
 */
public interface JsonEncoder {
    /**
     * 获取给定对象对应的JSON格式字符串
     * @param ins
     * @return
     */
    Object getJson(PmcCellLteMin ins) throws IOException;
}
