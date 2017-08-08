package cn.mateworks.essample.util;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by James Cheung on 2017/7/28.
 */
public class BulkIndexTest {
    public static void main(String[] args) throws IOException {
        Settings settings =Settings.builder()
                .put("client.transport.sniff", true).put("cluster.name", "hamster").build();
        Client client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.199",9300)))
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.141",9300)))
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.201",9300)));
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for(int i=0;i<1000;i++){
            bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user", "kimchy"+i)
                            .field("postDate", new Date())
                            .field("message", "trying out Elastic Search")
                            .endObject()
                    )
            );
        }
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            //错误
        }else{

        }
        client.close();
    }
}
