package com.unimedsci.ydata.jxc.main.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Alan on 2017/12/6.
 */
@JsonIgnoreProperties({"bytes"})
public class FileMeta {

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    private String fileName;
    private String fileSize;
    private String fileType;
    private String url;

    private byte[] bytes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //setters & getters
}