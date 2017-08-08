package cn.mateworks.essample.util;

import cn.mateworks.essample.model.PmcCellLteMin;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

/**
 * Created by James Cheung on 2017/7/24.
 */
public class JsonBuilderEncoder implements JsonEncoder {

    @Override
    public Object getJson(PmcCellLteMin ins) throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("CName", ins.getClname())
                .field("postDate", ins.getEnodebid())
                .field("drop_call_num", ins.getDrop_call_num())
                .field("drop_call_rate", ins.getDrop_call_rate())
                .field("erab_connestab_rate", ins.getErab_connestab_rate())
                .field("localcellid", ins.getLocalcellid())
                .field("max_user", ins.getMax_user())
                .field("pdcp_cpoctdl", ins.getPdcp_cpoctdl())
                .field("pdcp_cpoctul", ins.getPdcp_cpoctul())
                .field("prb_utilization", ins.getPrb_utilization())
                .field("prb_utilization_dl", ins.getPrb_utilization_dl())
                .field("rrc_connestab_rate", ins.getRrc_connestab_rate())
                .field("starttime", ins.getStarttime())
                .endObject();
        return builder.string();
    }

}
