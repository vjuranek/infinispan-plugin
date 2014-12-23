package org.jenkinsci.plugins.infinispan;

import hudson.DescriptorExtensionList;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;

public abstract class JCacheDescriptor extends Descriptor<JCache> {
	
    protected JCacheDescriptor() {
    }

    protected JCacheDescriptor(Class<? extends JCache> clazz) {
        super(clazz);
    }

    public static DescriptorExtensionList<JCache, JCacheDescriptor> all() {
        return Jenkins.getInstance().getDescriptorList(JCache.class);
    }
}