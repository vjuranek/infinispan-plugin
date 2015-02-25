package org.jenkinsci.plugins.infinispan;

import hudson.Extension;

import java.net.URI;

import javax.cache.CacheManager;

import org.infinispan.jcache.JCacheManager;
import org.infinispan.manager.DefaultCacheManager;

public class InfinispanCache extends JCache {

    private final transient CacheManager cm;

    public InfinispanCache() {
        cm = new JCacheManager(URI.create(InfinispanCache.class.getName()), new DefaultCacheManager(), null);
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
