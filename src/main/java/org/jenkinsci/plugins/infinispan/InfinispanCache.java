package org.jenkinsci.plugins.infinispan;

import hudson.Extension;

import java.net.URI;

import javax.cache.CacheManager;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.jcache.JCacheManager;
import org.infinispan.manager.DefaultCacheManager;
import org.jenkinsci.plugins.jcache.JCache;
import org.jenkinsci.plugins.jcache.JCacheDescriptor;

public class InfinispanCache extends JCache {

    private final transient CacheManager cm;

    public InfinispanCache() {
        GlobalConfigurationBuilder globalConfig = new GlobalConfigurationBuilder();
        globalConfig.globalJmxStatistics().allowDuplicateDomains(true);
        globalConfig.transport().defaultTransport().addProperty("configurationFile", "jenkins-jgroups-tcp.xml");
        globalConfig.classLoader(getClass().getClassLoader());
        DefaultCacheManager dcm = new DefaultCacheManager(globalConfig.build());
        
        ConfigurationBuilder cacheConfig = new ConfigurationBuilder();
        cacheConfig.clustering().cacheMode(CacheMode.REPL_SYNC);
        dcm.defineConfiguration("testCache", cacheConfig.build());
        
        cm = new JCacheManager(URI.create(InfinispanCache.class.getName()), dcm, null);
    }

    public CacheManager getCacheManager() {
        return cm;
    }
    
    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl)super.getDescriptor();
    }
    
    @Extension
    public static class DescriptorImpl extends JCacheDescriptor {
        
        @Override
        public String getDisplayName() {
            return "Infinispan cache";
        }
        
    }

}
