package com.crawler.business;

import com.crawler.entity.TestEntity;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlerDemo {

    public CrawlerDemo() {
    }

    public String getData(String url){
        String data = null;
        org.apache.commons.httpclient.HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("User_Agent", "Mozilla/5.0(Windows NT 6.1;Win64;x64;rv:39.0) Gecko/20100101 Firefox/39.0");
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());//系统默认的恢复策略
        getMethod.setRequestHeader("charset","UTF-8");
        try {
            int statusCode = client.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Wrong");
            }
            byte[] responseBody = getMethod.getResponseBody();
            data = new String(responseBody);
            return data;

        } catch (HttpException e) {
            System.out.println("Please check your provided http address!");
            data = "";
            e.printStackTrace();

        } catch (IOException e) {
            data = "";
            e.printStackTrace();
        } finally {

            getMethod.releaseConnection();

        }
        return data;
    }

    //想要获取字段部分的分割模式
    static Pattern proInfo = Pattern.compile("<td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td>" +
            "<td>(.*?)</td><td>(.*?)</td>", Pattern.DOTALL);

    private static List<TestEntity> getDataStructure(String str) {
        //想要获取的整段数据的分割模式
        String[] info = str.split("</tr>");
        List<TestEntity> list = new ArrayList<>();
        for (String s : info) {
            Matcher m = proInfo.matcher(s);
            TestEntity information = null;
            if (m.find()) {
                information = new TestEntity();
                String ss = m.group(1).trim();
                information.setType(ss);
                information.setDealAmount(m.group(2).trim());
                information.setDealStockAmount(m.group(3).trim());
                information.setMarketAmount(m.group(4).trim());
                information.setCirculationMarketValue(m.group(5).trim());
                information.setQuotedCompanyAmount(m.group(6).trim());
                information.setAveragePerOfStockMarket(m.group(7).trim());
                list.add(information);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        CrawlerDemo almanacUtil = new CrawlerDemo();
        String ss = almanacUtil.getData("http://quote.eastmoney.com/zs000001.html");
        List<TestEntity> list = getDataStructure(ss);
        String string = "";
        for (int k = 0; k < list.size(); k++) {
            String s = "类别：" + list.get(k).getType() + " " + "成交量：" + list.get(k).getDealStockAmount() + " " +
                    "成交金额：" + list.get(k).getDealAmount() + " " + "总市值：" + list.get(k).getMarketAmount() +
                    " " + "上市公司（家）:" + list.get(k).getQuotedCompanyAmount() + " " + "平均市盈率：" + list.get(k).getAveragePerOfStockMarket() + "\n";
            string = string + s;
        }
        System.out.println(string);
        File f = new File("D:" + File.separator + "gupiao.txt");//存在D盘guipiao.txt里
        OutputStream out = null;
        out = new FileOutputStream(f);
        byte b[] = string.getBytes();
        out.write(b);
        out.close();
    }
}
