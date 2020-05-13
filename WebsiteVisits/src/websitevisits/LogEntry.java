/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websitevisits;

/**
 *
 * @author USER
 */
public class LogEntry {
    private String ipAddress;
    private String accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;

    public LogEntry(String ipAddress, String accessTime, String request, int statusCode, int bytesReturned) {
        this.ipAddress = ipAddress;
        this.accessTime = accessTime;
        this.request = request;
        this.statusCode = statusCode;
        this.bytesReturned = bytesReturned;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public String getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setBytesReturned(int bytesReturned) {
        this.bytesReturned = bytesReturned;
    }

    @Override
    public String toString() {
        return "LogEntry{" + "ipAddress=" + ipAddress + ", accessTime=" + accessTime + ", request=" + request + ", statusCode=" + statusCode + ", bytesReturned=" + bytesReturned + '}';
    }
    
}
