package br.com.streamsoft.framework.base.resolver;

import com.sun.faces.facelets.impl.DefaultResourceResolver;

import java.net.URL;

public class ClassPathResolver extends DefaultResourceResolver
{
	public static final String PROTOCOL = "/resource";
	public static final String RESOURCE_PREFIX = "/META-INF/resources";

	public URL resolveUrl(String path)
	{
		if (path.startsWith(PROTOCOL))
		{
			String urlPath = RESOURCE_PREFIX
					+ path.substring(PROTOCOL.length());
			URL url = getClass().getResource(urlPath);
			return url;
		}
		return super.resolveUrl(path);

	}
}