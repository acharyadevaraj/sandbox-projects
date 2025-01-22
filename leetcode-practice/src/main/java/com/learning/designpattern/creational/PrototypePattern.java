package com.learning.designpattern.creational;

import lombok.Data;

@Data
class NetworkConnection implements Cloneable {
    private String ip;
    private String data;

    public void loadImportantData() throws InterruptedException {
        this.data = "Important Data";
        Thread.sleep(2000);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        NetworkConnection connection = new NetworkConnection();
        connection.setIp("1.3.4.5");
        connection.loadImportantData();
        System.out.println(connection);

        NetworkConnection networkConnection = (NetworkConnection) connection.clone();
        System.out.println(networkConnection);
    }
}
