package com.bupt.openiot.common.registry.service;

/**
 * 服务注册表
 * Created by dy on 2017/6/2.
 */
public interface ServiceRegistry {

    /**
     * 注册服务信息
     * @param serviceName    服务名称
     * @param serviceAddress 服务地址
     */
    void registry(String serviceName, String serviceAddress);
}
