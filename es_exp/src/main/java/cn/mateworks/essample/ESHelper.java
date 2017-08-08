package cn.mateworks.essample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.stats.IndexStats;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsRequest;
import org.elasticsearch.action.admin.indices.stats.IndicesStatsResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;


import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

/**
 * Created by James Cheung on 2017/7/26.
 */
public class ESHelper {

    protected static final String INDEX_DEMO_01 = "index_demo_01";
    protected static final String INDEX_DEMO_01_MAPPING = "index_demo_01_mapping";
    //
    protected static final String LOG_STASH_YYYY_MM_DD = "logstash-2014.08.16";
    protected static final String LOG_STASH_YYYY_MM_DD_MAPPING = "logstash_yyyy_mm_dd_mapping";
    //直接传入 index_demo_*  即按前缀* 查询
    static final String INDEX_DEMO_ALL = "index_demo_*";
    protected static Client client;

    /**
     * startup Transport Client
     * 启动es
     */
    protected static void startupClient() {
        /**
         * 可以设置client.transport.sniff为true来使客户端去嗅探整个集群的状态，
         * 把集群中其它机器的ip地址加到客户端中，这样做的好处是一般你不用手动设置集群
         * 里所有集群的ip到连接客户端，它会自动帮你添加，并且自动发现新加入集群的机器。
         */
        Settings settings =Settings.builder()
                .put("client.transport.sniff", true).put("cluster.name", "hamster").build();

        client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.199",9300)))
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.141",9300)))
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.201",9300)));
        //.addTransportAddress(new InetSocketTransportAddress("10.211.55.4", 9300));
        // System.out.println(INDEX_DEMO_01 + "是否存在？-》" + client.admin().indices().exists(new IndicesExistsRequest(INDEX_DEMO_01)).actionGet().isExists());
    }

    /**
     * on shutDownClient
     * 停止es
     */
    static void shutDownClient() {
        client.close();
    }
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取所有index
     */
    protected static void getAllIndices() {
        ActionFuture<IndicesStatsResponse> isr = client.admin().indices().stats(new IndicesStatsRequest().all());
        IndicesAdminClient indicesAdminClient = client.admin().indices();
        Map<String, IndexStats> indexStatsMap = isr.actionGet().getIndices();
        Set<String> set = isr.actionGet().getIndices().keySet();
        set.forEach(System.out::println);
    }

    /**
     * 打印SearchResponse结果集
     *
     * @param response response
     */
    static void writeSearchResponse(SearchResponse response) {
        SearchHit[] searchHitsByPrepareSearch = response.getHits().hits();
        //获取结果集打印
        for (SearchHit searchHit : searchHitsByPrepareSearch) {
            System.out.println(searchHit.getSourceAsString());
        }
    }


    public static String toJson(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
