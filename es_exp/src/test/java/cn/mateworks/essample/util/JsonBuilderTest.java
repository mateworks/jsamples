package cn.mateworks.essample.util;

import cn.mateworks.essample.ESHelper;
import cn.mateworks.essample.IndexMappingBuilder;
import cn.mateworks.essample.PmcCellLteProducer;
import cn.mateworks.essample.model.LogModel;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by James Cheung on 2017/7/25.
 */
public class JsonBuilderTest {

    public static void main(String[] args) throws IOException {

        Settings settings =Settings.builder()
                .put("client.transport.sniff", true).put("cluster.name", "hamster").build();
        /*
         * 创建客户端，所有的操作都由客户端开始，这个就好像是JDBC的Connection对象
         * 用完记得要关闭
         */
        Client client =  new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("192.168.2.199",9300)));
        String json = ESHelper.toJson(new LogModel());
        //在这里创建我们要索引的对象
        IndexResponse response = client.prepareIndex("twitter", "tweet")
                //必须为对象单独指定ID
                .setId("1")
                .setSource(json)
                .execute()
                .actionGet();
        //多次index这个版本号会变
        System.out.println("response.version():"+response.getVersion());
        //测试获取
        GetResponse getResponse = client.prepareGet("twitter", "tweet", "1")
                .execute().actionGet();
        System.out.println("response.getId():"+response.getId());
        System.out.println("response.getSourceAsString():"+getResponse.getSourceAsString());
        //测试删除
        DeleteResponse delResponse = client.prepareDelete("twitter", "tweet", "1")
                .execute().actionGet();
        System.out.println(delResponse.getId());
        System.out.println(ESHelper.toJson(delResponse));

        client.close();
    }



}
