package cn.mateworks.essample;

import cn.mateworks.essample.model.PmcCellLteMin;

import java.util.Random;

/**
 * 用于生产测试使用的PmcCellLteMin对象集合
 * Created by James Cheung on 2017/7/25.
 */
public class PmcCellLteProducer {
    final static Random random=new Random(System.currentTimeMillis());
    final static String defaultCellName="CellName";
    public static PmcCellLteMin randomPmcCellLteMin(){
        PmcCellLteMin pcm = new PmcCellLteMin();
        pcm.setClname(defaultCellName);
        pcm.setDrop_call_num(random.nextFloat());
        pcm.setEnodebid(random.nextInt()+"");
        pcm.setDrop_call_rate(random.nextFloat());
        pcm.setPrb_utilization_dl(random.nextFloat());
        pcm.setMax_user(random.nextInt());
        pcm.setErab_connestab_rate(random.nextFloat());
        pcm.setPdcp_cpoctdl(random.nextFloat());
        pcm.setPdcp_cpoctul(random.nextFloat());
        return pcm;
    }
}
