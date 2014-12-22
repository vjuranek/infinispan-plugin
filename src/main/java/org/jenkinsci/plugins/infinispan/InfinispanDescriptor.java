package org.jenkinsci.plugins.infinispan;

import hudson.DescriptorExtensionList;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;

public abstract class InfinispanDescriptor extends Descriptor<Infinispan> {
	
    protected InfinispanDescriptor() {
    }

    protected InfinispanDescriptor(Class<? extends Infinispan> clazz) {
        super(clazz);
    }

    public static DescriptorExtensionList<Infinispan, InfinispanDescriptor> all() {
        return Jenkins.getInstance().getDescriptorList(Infinispan.class);
    }
}