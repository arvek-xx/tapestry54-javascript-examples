package no.mil.tap54.services;

import no.mil.tap54.rest.PhoneResource;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Autobuild;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;

public class AppModule
{
	public static void bind(ServiceBinder binder)
	{
		// binder.bind(MyServiceInterface.class, MyServiceImpl.class);
	}

	public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration)
	{
		configuration.override(SymbolConstants.APPLICATION_VERSION, "0.1.3 (2015-09-21)");
		configuration.override(SymbolConstants.PRODUCTION_MODE, false);
	}

	public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration)
	{
		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
		configuration.add(SymbolConstants.HMAC_PASSPHRASE, "someThingForSecurityInTap54");
	}

	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void setupEnvironment(MappedConfiguration<String, Object> configuration)
	{
		configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
		configuration.add(SymbolConstants.BOOTSTRAP_ROOT, "context:mybootstrap");
		configuration.add(SymbolConstants.MINIFICATION_ENABLED, true);
	}

	/**
	 * Configure Rest resources
	 * 
	 * @param singletons
	 * @param phoneResource
	 */
	@Contribute(javax.ws.rs.core.Application.class)
	public static void configurePhoneRestResources(Configuration<Object> singletons, @Autobuild PhoneResource phoneResource)
	{
		singletons.add(phoneResource);
	}
	
	/**
	 * Example: Get and put eg. javascript in Maven Dependencies from pom.xml.
	 * See http://www.webjars.org/
	 * 
	 * removed due to tapestry-react's use of WebJars
	 * 
	 * @param configuration
	 */
//	public static void contributeClasspathAssetAliasManager(MappedConfiguration<String, String> configuration)
//	{
//		configuration.add("webjars", "META-INF/resources/webjars");
//	}

}
