// generated by tscfg 0.8.0 on Tue Apr 18 00:19:20 PDT 2017
// source: etc/config/spec.conf

package com.sudothought.common;

public class CoreConfig {
  public final CoreConfig.Agent  agent;
  public final CoreConfig.Proxy2 proxy;
  public CoreConfig(com.typesafe.config.Config c) {
    this.agent = new CoreConfig.Agent(c.getConfig("agent"));
    this.proxy = new CoreConfig.Proxy2(c.getConfig("proxy"));
  }

  public static class Agent {
    public final Agent.Metrics                         metrics;
    public final java.util.List<Agent.PathConfigs$Elm> pathConfigs;
    public final Agent.Proxy                           proxy;
    public final Agent.Zipkin                          zipkin;
    public Agent(com.typesafe.config.Config c) {
      this.metrics = new Agent.Metrics(c.getConfig("metrics"));
      this.pathConfigs = $_LAgent_PathConfigs$Elm(c.getList("pathConfigs"));
      this.proxy = new Agent.Proxy(c.getConfig("proxy"));
      this.zipkin = new Agent.Zipkin(c.getConfig("zipkin"));
    }

    private static java.util.List<Agent.PathConfigs$Elm> $_LAgent_PathConfigs$Elm(com.typesafe.config.ConfigList cl) {
      java.util.ArrayList<Agent.PathConfigs$Elm> al = new java.util.ArrayList<>();
      for (com.typesafe.config.ConfigValue cv : cl) {
        al.add(new Agent.PathConfigs$Elm(((com.typesafe.config.ConfigObject) cv).toConfig()));
      }
      return java.util.Collections.unmodifiableList(al);
    }

    public static class Metrics {
      public final int port;

      public Metrics(com.typesafe.config.Config c) {
        this.port = c.hasPathOrNull("port") ? c.getInt("port") : 8083;
      }
    }

    public static class PathConfigs$Elm {
      public final java.lang.String name;
      public final java.lang.String path;
      public final java.lang.String url;

      public PathConfigs$Elm(com.typesafe.config.Config c) {
        this.name = c.getString("name");
        this.path = c.getString("path");
        this.url = c.getString("url");
      }
    }

    public static class Proxy {
      public final java.lang.String hostname;
      public final int              port;

      public Proxy(com.typesafe.config.Config c) {
        this.hostname = c.hasPathOrNull("hostname") ? c.getString("hostname") : "localhost";
        this.port = c.hasPathOrNull("port") ? c.getInt("port") : 50051;
      }
    }

    public static class Zipkin {
      public final java.lang.String host;
      public final java.lang.String serviceName;

      public Zipkin(com.typesafe.config.Config c) {
        this.host = c.hasPathOrNull("host") ? c.getString("host") : null;
        this.serviceName = c.hasPathOrNull("serviceName") ? c.getString("serviceName") : "prometheus-agent";
      }
    }
  }

  public static class Proxy2 {
    public final Proxy2.Grpc     grpc;
    public final Proxy2.Http     http;
    public final Proxy2.Metrics2 metrics;
    public final Proxy2.Zipkin2  zipkin;
    public Proxy2(com.typesafe.config.Config c) {
      this.grpc = new Proxy2.Grpc(c.getConfig("grpc"));
      this.http = new Proxy2.Http(c.getConfig("http"));
      this.metrics = new Proxy2.Metrics2(c.getConfig("metrics"));
      this.zipkin = new Proxy2.Zipkin2(c.getConfig("zipkin"));
    }

    public static class Grpc {
      public final int port;

      public Grpc(com.typesafe.config.Config c) {
        this.port = c.hasPathOrNull("port") ? c.getInt("port") : 50051;
      }
    }

    public static class Http {
      public final int port;

      public Http(com.typesafe.config.Config c) {
        this.port = c.hasPathOrNull("port") ? c.getInt("port") : 8080;
      }
    }

    public static class Metrics2 {
      public final int port;

      public Metrics2(com.typesafe.config.Config c) {
        this.port = c.hasPathOrNull("port") ? c.getInt("port") : 8082;
      }
    }

    public static class Zipkin2 {
      public final java.lang.String hostname;
      public final int              port;
      public final java.lang.String serviceName;

      public Zipkin2(com.typesafe.config.Config c) {
        this.hostname = c.hasPathOrNull("hostname") ? c.getString("hostname") : null;
        this.port = c.hasPathOrNull("port") ? c.getInt("port") : 9411;
        this.serviceName = c.hasPathOrNull("serviceName") ? c.getString("serviceName") : "prometheus-proxy";
      }
    }
  }
}
      
