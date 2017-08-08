package cn.mateworks.essample;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建Mapping和索引数据，将测试数据导入ES
 *
 * Created by James Cheung on 2017/7/26.
 */
public class IndexMappingBuilder {

    public IndexMappingBuilder(){
        ESHelper.startupClient();
    }
    /**
     *
     */
    public void buildIndexMapping() throws IOException {
        Map<String, Object> settings = new HashMap<>();
        settings.put("number_of_shards", 4);//分片数量
        settings.put("number_of_replicas", 0);//复制数量
        settings.put("refresh_interval", "10s");//刷新时间

        CreateIndexRequestBuilder cib =
                ESHelper.client.admin().indices()
                        .prepareCreate(ESHelper.LOG_STASH_YYYY_MM_DD);
        cib.setSettings(settings);

        XContentBuilder mapping = XContentFactory.jsonBuilder()
                .startObject()
                //properties下定义的name等等就是属于我们需要的自定义字段了,相当于数据库中的表字段 ,此处相当于创建数据库表
                .startObject("properties")
                .startObject("@timestamp").field("type", "long").endObject()
                .startObject("name").field("type", "string").field("store", "yes").endObject()
                .startObject("home").field("type", "string").field("index", "not_analyzed").endObject()
                .startObject("now_home").field("type", "string").field("index", "not_analyzed").endObject()
                .startObject("height").field("type", "double").endObject()
                .startObject("age").field("type", "integer").endObject()
                .startObject("isRealMen").field("type", "boolean").endObject()
                //.startObject("location").field("lat", "double").field("lon", "double").endObject()
                //.endObject()
                .endObject()
                .endObject();
        cib.addMapping("test_01", mapping);
        CreateIndexResponse createIndexResponse = cib.execute().actionGet();
        createIndexResponse.toString();
    }


}
