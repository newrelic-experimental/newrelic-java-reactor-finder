package com.newrelic.agent.instrumentation.pointcuts.frameworks.reactor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.agent.deps.org.objectweb.asm.ClassReader;
import com.newrelic.agent.instrumentation.classmatchers.ClassMatcher;
import com.newrelic.api.agent.Config;
import com.newrelic.api.agent.NewRelic;

/**
 * Class matcher that matches any class that doesn't belong to reactor.core or its subpackages and
 * whose package name starts with a configured name
 * 
 * @author dhilpipre
 *
 */
public class ReactorClassMatcher extends ClassMatcher {

	private static final Set<String> PACKAGES_TO_TRACE = new HashSet<>();
	private static final String PACKAGES_SETTING = "reactor-finder.packages";

	static {
		Config config = NewRelic.getAgent().getConfig();
		String setting = config.getValue(PACKAGES_SETTING);
		if (setting != null) {
			String[] packages = setting.split(",");
			PACKAGES_TO_TRACE.addAll(Arrays.asList(packages));

			// Disallow tracking of Reactor Framework classes
			for(String pkg : packages) {
				if(pkg.startsWith("reactor.")) {
					PACKAGES_TO_TRACE.remove(pkg);
				}
			}
		}
	}

	@Override
	public Collection<String> getClassNames() {
		return Collections.emptyList();	
	}

	@Override
	public boolean isMatch(Class<?> clazz) {
		if(clazz.isAnnotation()) return false;
		
		Package classPackage = clazz.getPackage();
		if(classPackage == null) return false;
		String packageName = classPackage.getName();

		for(String pkg : PACKAGES_TO_TRACE) {
			if(packageName.startsWith(pkg)) {return true;}
		}
		return false;
	}

	@Override
	public boolean isMatch(ClassLoader loader, ClassReader cr) {
        if (loader == null) {
            loader = AgentBridge.getAgent().getClass().getClassLoader();
        }

 		String className = cr.getClassName();

		for (String pkg : PACKAGES_TO_TRACE) {
			if (className.startsWith(pkg)) {
				return true;
			}
		}
		return false;
	}

}
