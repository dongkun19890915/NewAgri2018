package com.sinosoft.turbine.discovery;

import com.netflix.appinfo.AmazonInfo;
import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.turbine.discovery.Instance;
import org.springframework.cloud.netflix.turbine.EurekaInstanceDiscovery;
import org.springframework.cloud.netflix.turbine.TurbineProperties;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 2017/8/25.
 */
public class SinoEurekaInstanceDiscovery extends EurekaInstanceDiscovery {
    public SinoEurekaInstanceDiscovery(TurbineProperties turbineProperties, EurekaClient eurekaClient) {
        super(turbineProperties, eurekaClient);
    }

    @Override
    protected List<Instance> getInstancesForApp(String serviceId) throws Exception {
        return super.getInstancesForApp(serviceId);
    }
}
