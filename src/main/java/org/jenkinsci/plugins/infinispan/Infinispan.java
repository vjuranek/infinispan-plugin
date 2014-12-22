package org.jenkinsci.plugins.infinispan;
import hudson.ExtensionPoint;
import hudson.model.AbstractDescribableImpl;


public abstract class Infinispan extends AbstractDescribableImpl<Infinispan> implements ExtensionPoint {

	@Override
    public InfinispanDescriptor getDescriptor() {
        return (InfinispanDescriptor)super.getDescriptor();
    }
	
}

