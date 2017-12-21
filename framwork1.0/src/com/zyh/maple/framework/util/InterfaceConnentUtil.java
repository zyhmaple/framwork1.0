/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class InterfaceConnentUtil {
    public static Document AcceptAndSendXmlFile(String httpUrl, String xmlStr) throws Exception {
        Document document;
        block12 : {
            document = null;
            InputStream in = null;
            HttpURLConnection conn = null;
            try {
                try {
                    byte[] xmlbyte = xmlStr.getBytes("UTF-8");
                    URL url = new URL(httpUrl);
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setConnectTimeout(6000);
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Connection", "Keep-Alive");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.setRequestProperty("Content-Length", String.valueOf(xmlbyte.length));
                    conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
                    DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
                    outStream.write(xmlbyte);
                    outStream.flush();
                    outStream.close();
                    if (conn.getResponseCode() == 200) {
                        in = conn.getInputStream();
                        SAXReader saxReader = new SAXReader();
                        document = saxReader.read(in);
                        in.close();
                        break block12;
                    }
                    throw new Exception("\u8fde\u63a5\u8fd4\u56de\u7684\u9519\u8bef\u4ee3\u7801\u4e3a\uff1a" + conn.getResponseCode());
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("\u8bf7\u68c0\u67e5\u8fde\u63a5 = " + httpUrl);
                    throw new Exception(e);
                }
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    }
                    catch (IOException e) {
                        in = null;
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }
        return document;
    }

    public static String AcceptAndSendXmlFile2Str(String httpUrl, String xmlStr) throws Exception {
        Document document;
        block12 : {
            document = null;
            InputStream in = null;
            HttpURLConnection conn = null;
            try {
                try {
                    byte[] xmlbyte = xmlStr.getBytes("UTF-8");
                    URL url = new URL(httpUrl);
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setConnectTimeout(6000);
                    conn.setDoOutput(true);
                    conn.setUseCaches(false);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Connection", "Keep-Alive");
                    conn.setRequestProperty("Charset", "UTF-8");
                    conn.setRequestProperty("Content-Length", String.valueOf(xmlbyte.length));
                    conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
                    DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
                    outStream.write(xmlbyte);
                    outStream.flush();
                    outStream.close();
                    if (conn.getResponseCode() == 200) {
                        String code = conn.getHeaderField("Content-Encodeing");
                        System.out.println("gzipcode = " + code);
                        in = conn.getInputStream();
                        SAXReader saxReader = new SAXReader();
                        saxReader.setEncoding("UTF-8");
                        document = saxReader.read(in);
                        in.close();
                        break block12;
                    }
                    throw new Exception("\u8fde\u63a5\u8fd4\u56de\u7684\u9519\u8bef\u4ee3\u7801\u4e3a\uff1a" + conn.getResponseCode());
                }
                catch (Exception e) {
                    System.out.println("\u8bf7\u68c0\u67e5\u8fde\u63a5 = " + httpUrl);
                    throw new Exception(e);
                }
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    }
                    catch (IOException e) {
                        in = null;
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }
        return document.asXML();
    }

    public static Document readXmlInputStream(InputStream in) throws Exception {
        Document document;
        block11 : {
            document = null;
            try {
                try {
                    if (in != null) {
                        SAXReader saxReader = new SAXReader();
                        document = saxReader.read(in);
                        in.close();
                        break block11;
                    }
                    throw new Exception("\u8f93\u5165\u6d41\u4e3a\u7a7a\uff1a" + in);
                }
                catch (Exception e) {
                    throw new Exception(e);
                }
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    }
                    catch (IOException e) {
                        in = null;
                        e.printStackTrace();
                    }
                }
            }
        }
        return document;
    }

    public static String readXmlInputStream2Str(InputStream in) throws Exception {
        Document document;
        block11 : {
            document = null;
            try {
                try {
                    if (in != null) {
                        SAXReader saxReader = new SAXReader();
                        document = saxReader.read(in);
                        in.close();
                        break block11;
                    }
                    throw new Exception("\u8f93\u5165\u6d41\u4e3a\u7a7a\uff1a" + in);
                }
                catch (Exception e) {
                    throw new Exception(e);
                }
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    }
                    catch (IOException e) {
                        in = null;
                        e.printStackTrace();
                    }
                }
            }
        }
        return document.asXML();
    }

    public static Document sendURLAndGetXmlFile(String httpNewUrl) {
        Document document;
        document = null;
        URL url = null;
        InputStream in = null;
        HttpURLConnection httpurlconnection = null;
        try {
            try {
                url = new URL(httpNewUrl);
                httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("POST");
                in = httpurlconnection.getInputStream();
                SAXReader saxReader = new SAXReader();
                document = saxReader.read(in);
                in.close();
            }
            catch (Exception e) {
                System.out.println("\u8bf7\u68c0\u67e5\u8fde\u63a5 = " + httpNewUrl);
                e.printStackTrace();
                if (in != null) {
                    try {
                        in.close();
                    }
                    catch (IOException e2) {
                        in = null;
                        e2.printStackTrace();
                    }
                }
                if (httpurlconnection != null) {
                    httpurlconnection.disconnect();
                }
            }
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException e) {
                    in = null;
                    e.printStackTrace();
                }
            }
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
        return document;
    }

    public static String sendURLAndGetXmlFile2Str(String httpNewUrl) throws Exception {
        Node document;
        block19 : {
            HttpURLConnection httpurlconnection;
            GZIPInputStream gin;
            document = null;
            URL url = null;
            gin = null;
            Object data = null;
            httpurlconnection = null;
            InputStream input = null;
            try {
                try {
                    url = new URL(httpNewUrl);
                    httpurlconnection = (HttpURLConnection)url.openConnection();
                    httpurlconnection.setDoOutput(true);
                    httpurlconnection.setRequestMethod("GET");
                    httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
                    httpurlconnection.setRequestProperty("Charset", "UTF-8");
                    String code = httpurlconnection.getHeaderField("Content-Encoding");
                    input = httpurlconnection.getInputStream();
                    SAXReader saxReader = new SAXReader();
                    if (code != null && "gzip".equals(code.toLowerCase())) {
                        gin = new GZIPInputStream(input);
                        document = saxReader.read(gin);
                        gin.close();
                    } else {
                        document = saxReader.read(input);
                    }
                }
                catch (Exception e) {
                    System.out.println("\u8bf7\u68c0\u67e5\u8fde\u63a5 = " + httpNewUrl);
                    e.printStackTrace();
                    if (gin != null) {
                        try {
                            gin.close();
                        }
                        catch (IOException e2) {
                            gin = null;
                            e2.printStackTrace();
                        }
                    }
                    if (httpurlconnection != null) {
                        httpurlconnection.disconnect();
                    }
                    break block19;
                }
            }
            catch (Throwable throwable) {
                if (gin != null) {
                    try {
                        gin.close();
                    }
                    catch (IOException e) {
                        gin = null;
                        e.printStackTrace();
                    }
                }
                if (httpurlconnection != null) {
                    httpurlconnection.disconnect();
                }
                throw throwable;
            }
            if (gin != null) {
                try {
                    gin.close();
                }
                catch (IOException e) {
                    gin = null;
                    e.printStackTrace();
                }
            }
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
        return document.asXML();
    }

    public static String sendURLAndGetJsonStr(String httpNewUrl) throws Exception {
        String resultStr;
        URL url = null;
        Object data = null;
        HttpURLConnection httpurlconnection = null;
        GZIPInputStream input = null;
        resultStr = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            try {
                int n;
                url = new URL(httpNewUrl);
                httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("GET");
                httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
                httpurlconnection.setRequestProperty("Charset", "UTF-8");
                String code = httpurlconnection.getHeaderField("Content-Encoding");
                input = new GZIPInputStream(httpurlconnection.getInputStream());
                byte[] buffer = new byte[1025];
                while ((n = input.read(buffer)) >= 0) {
                    out.write(buffer, 0, n);
                }
                resultStr = out.toString("UTF-8");
                out.close();
                input.close();
            }
            catch (Exception e) {
                System.out.println("\u8bf7\u68c0\u67e5\u8fde\u63a5 = " + httpNewUrl);
                e.printStackTrace();
                if (input != null) {
                    try {
                        input.close();
                    }
                    catch (IOException e2) {
                        input = null;
                        e2.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    }
                    catch (IOException e3) {
                        out = null;
                        e3.printStackTrace();
                    }
                }
                if (httpurlconnection != null) {
                    httpurlconnection.disconnect();
                }
            }
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    input = null;
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                }
                catch (IOException e) {
                    out = null;
                    e.printStackTrace();
                }
            }
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
        return resultStr;
    }

    public static String sendURLAndGetStr(String httpNewUrl, String encoding) throws Exception {
        String resultStr;
        URL url = null;
        Object data = null;
        HttpURLConnection httpurlconnection = null;
        InputStream input = null;
        resultStr = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            try {
                int n;
                url = new URL(httpNewUrl);
                httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("GET");
                httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
                httpurlconnection.setRequestProperty("Charset", encoding);
                String code = httpurlconnection.getHeaderField("Content-Encoding");
                input = code != null && "gzip".equals(code.toLowerCase()) ? new GZIPInputStream(httpurlconnection.getInputStream()) : httpurlconnection.getInputStream();
                byte[] buffer = new byte[1025];
                while ((n = input.read(buffer)) >= 0) {
                    out.write(buffer, 0, n);
                }
                resultStr = out.toString("UTF-8");
                out.close();
                input.close();
            }
            catch (Exception e) {
                System.out.println("\u8bf7\u68c0\u67e5\u8fde\u63a5 = " + httpNewUrl);
                e.printStackTrace();
                if (input != null) {
                    try {
                        input.close();
                    }
                    catch (IOException e2) {
                        input = null;
                        e2.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    }
                    catch (IOException e3) {
                        out = null;
                        e3.printStackTrace();
                    }
                }
                if (httpurlconnection != null) {
                    httpurlconnection.disconnect();
                }
            }
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    input = null;
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                }
                catch (IOException e) {
                    out = null;
                    e.printStackTrace();
                }
            }
            if (httpurlconnection != null) {
                httpurlconnection.disconnect();
            }
        }
        return resultStr;
    }

    public static String sendURLAndGetStr(String httpNewUrl) throws Exception {
        return InterfaceConnentUtil.sendURLAndGetStr(httpNewUrl, "UTF-8");
    }

    public static String uncompressToString(byte[] b, String encoding) {
        if (b == null || b.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        try {
            int n;
            GZIPInputStream gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

