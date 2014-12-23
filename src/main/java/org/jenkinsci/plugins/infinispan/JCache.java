package org.jenkinsci.plugins.infinispan;
import hudson.ExtensionPoint;
import hudson.model.AbstractDescribableImpl;


public abstract class JCache extends AbstractDescribableImpl<JCache> implements ExtensionPoint {

	@Override
    public JCacheDescriptor getDescriptor() {
        return (JCacheDescriptor)super.getDescriptor();
    }
	
}

