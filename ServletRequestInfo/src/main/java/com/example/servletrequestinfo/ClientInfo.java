package com.example.servletrequestinfo;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope("prototype")
public class ClientInfo {
   private String localAddress;
   private String remoteAdress;
   private String remoteHost;

   public String getLocalAddress() {
      return localAddress;
   }

   public String getRemoteAdress() {
      return remoteAdress;
   }

   public String getRemoteHost() {
      return remoteHost;
   }

   public int getLocalPort() {
      return localPort;
   }

   public int getRemotePort() {
      return remotePort;
   }

   public LocalDateTime getLocalDateTime() {
      return localDateTime;
   }

   private int localPort;
   private int remotePort;
   private final LocalDateTime  localDateTime = LocalDateTime.now();

   public ClientInfo setLocalAddress(String localAddress) {
      this.localAddress = localAddress;
      return this;
   }

   public ClientInfo setRemoteAdress(String remoteAdress) {
      this.remoteAdress = remoteAdress;
      return this;
   }

   public ClientInfo setRemoteHost(String remoteHost) {
      this.remoteHost = remoteHost;
      return this;
   }

   public ClientInfo setLocalPort(int localPort) {
      this.localPort = localPort;
      return this;
   }

   public ClientInfo setRemotePort(int remotePort) {
      this.remotePort = remotePort;
      return this;
   }

   @Override
   public String toString() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
      String formatStr = "Local Address: %s, Remote Adress: %s, Local Port: %s, Remote Port: %s, Request Time: %s";
      return String.format(formatStr, localAddress, remoteAdress,
              remoteHost, localPort, remotePort, formatter.format(localDateTime));
   }
}
