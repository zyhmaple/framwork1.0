/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.util;

import java.util.HashMap;
import java.util.Map;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class DMFdfsUtil {
    public static String uploadFileToFdfs(String filePath, String fileName) throws Exception {
        String fileID;
        fileID = null;
        TrackerServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            try {
                TrackerClient tracker = new TrackerClient();
                trackerServer = tracker.getConnection();
                StorageClient1 client = new StorageClient1(trackerServer, (StorageServer)storageServer);
                NameValuePair[] metaList = new NameValuePair[1];
                metaList[0] = fileName != null && !"".equals(fileName) ? new NameValuePair("fileName", fileName) : new NameValuePair("fileName", filePath.substring(filePath.lastIndexOf("/") + 1));
                fileID = client.upload_file1(filePath, null, metaList);
            }
            catch (Exception e) {
                throw new Exception(e);
            }
        }
        finally {
            if (storageServer != null) {
                storageServer.close();
            }
            if (trackerServer != null) {
                trackerServer.close();
            }
        }
        return fileID;
    }

    public static String uploadFileToFdfs(byte[] file, String fileName) throws Exception {
        String fileID;
        fileID = null;
        TrackerServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            try {
                TrackerClient tracker = new TrackerClient();
                trackerServer = tracker.getConnection();
                StorageClient1 client = new StorageClient1(trackerServer, (StorageServer)storageServer);
                NameValuePair[] metaList = new NameValuePair[1];
                metaList[0] = fileName != null ? new NameValuePair("fileName", fileName) : new NameValuePair("fileName", "noFileName");
                fileID = client.upload_file1(file, null, metaList);
            }
            catch (Exception e) {
                throw new Exception(e);
            }
        }
        finally {
            if (storageServer != null) {
                storageServer.close();
            }
            if (trackerServer != null) {
                trackerServer.close();
            }
        }
        return fileID;
    }

    public static Map downLoadFileFromFdfs(String fileID) throws Exception {
        HashMap<String, String> fileMap;
        fileMap = null;
        TrackerServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            try {
                TrackerClient tracker = new TrackerClient();
                trackerServer = tracker.getConnection();
                StorageClient1 client = new StorageClient1(trackerServer, (StorageServer)storageServer);
                byte[] fileByte = client.download_file1(fileID);
                String fileName = client.get_metadata1(fileID)[0].getValue();
                fileMap = new HashMap<String, String>();
                fileMap.put("fileName", fileName);
                fileMap.put("fileByte", fileByte.toString());
            }
            catch (Exception e) {
                throw new Exception(e);
            }
        }
        finally {
            if (storageServer != null) {
                storageServer.close();
            }
            if (trackerServer != null) {
                trackerServer.close();
            }
        }
        return fileMap;
    }

    public static int delFileFromFdfs(String fileID) throws Exception {
        int result;
        result = 2;
        TrackerServer storageServer = null;
        TrackerServer trackerServer = null;
        try {
            try {
                TrackerClient tracker = new TrackerClient();
                trackerServer = tracker.getConnection();
                StorageClient1 client = new StorageClient1(trackerServer, (StorageServer)storageServer);
                result = client.delete_file1(fileID);
            }
            catch (Exception e) {
                throw new Exception(e);
            }
        }
        finally {
            if (storageServer != null) {
                storageServer.close();
            }
            if (trackerServer != null) {
                trackerServer.close();
            }
        }
        return result;
    }
}

