package com.my.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/8 16:26
 */
public interface LoadBalance {

    ServiceInstance instances (List<ServiceInstance> serviceInstances);
}
