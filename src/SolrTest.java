import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class SolrTest {
    @Test
    public void test() throws IOException, SolrServerException {
        /**
         * 创建连接
         * 创建文档
         * 在指定的域添加值（添加的域必须要存在）
         * 提交
         */
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
        SolrInputDocument document = new SolrInputDocument();
        //域名 域值
        document.addField("id","1");
        document.addField("name","小米");
        document.addField("description","为发烧而生");
        //将文档放入服务中,由服务提交
        server.add(document);
        server.commit();
    }

    @Test
    public void delete() throws IOException, SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
        server.deleteById("1");
        server.commit();



    }

}
