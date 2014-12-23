package org.jenkinsci.plugins.infinispan;
import hudson.ExtensionPoint;
import hudson.model.AbstractDescribableImpl;

import javax.cache.CacheManager;


public abstract class JCache extends AbstractDescribableImpl<JCache> implements ExtensionPoint {
    
    public abstract CacheManager getCacheManager();

	@Override
    public JCacheDescriptor getDescriptor() {
        return (JCacheDescriptor)super.getDescriptor();
    }
	
}

