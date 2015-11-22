package team.hidro.highschoolsupport.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.UnresolvingLocaleDefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan({"team.hidro.highschoolsupport.controllers", "team.hidro.highschoolsupport.dao.impl", "team.hidro.highschoolsupport.service.impl"})
@EnableWebMvc
@Import(value = { SecurityConfig.class, DbConfig.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	private static final Map<String, Definition> tiles = new HashMap<String,Definition>();
	private static final Attribute TEMPLATE = new Attribute("/WEB-INF/templates/layout.jsp");

	@Bean
	public ViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/data/**").addResourceLocations("/data/");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
		MappingJackson2HttpMessageConverter cv = new MappingJackson2HttpMessageConverter();
		converters.add(cv);
	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", Charset.forName("UTF-8"))));
		return converter;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor());
		// registry.addInterceptor(new
		// TransactionInterceptor()).addPathPatterns("/person/save/*");
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitionsFactoryClass(JavaDefinitionsFactory.class);
		tilesConfigurer.setDefinitions(new String[] {});
		
		addDefinition("home", "Home", "/WEB-INF/views/home.jsp");
		addDefinition("group", "Group", "/WEB-INF/views/group1.jsp");
		addDefinition("login", "Login", "/WEB-INF/views/login.jsp");
		addDefinition("profile", "Profile", "/WEB-INF/views/profile.jsp");
		addDefinition("status", "Status", "/WEB-INF/views/status.jsp");
		addDefinition("avg_grade", "Avarage Grade", "/WEB-INF/views/avg_grade.jsp");

		addDefinition("calendar", "Calendar", "/WEB-INF/views/calendar.jsp");
		addDefinition("lifecalendar", "Schedule", "/WEB-INF/views/lifecalendar.jsp");
		//addDefinition("signin/facebook", "Sign in", "/WEB-INF/views/signin.jsp");
		
		return tilesConfigurer;
	}
	private void addDefinition(String name, String title, String body) {
		Map<String, Attribute> attributes = (name.equals("login")) ? new HashMap<String,Attribute>() : getDefaultAttributes();
		
		attributes.put("title", new Attribute(title));
		attributes.put("body", new Attribute(body));
		tiles.put(name, new Definition(name, TEMPLATE, attributes));
	}
	private Map<String, Attribute> getDefaultAttributes() {
		Map<String, Attribute> attributes = new HashMap<String,Attribute>();
		attributes.put("header", new Attribute("/WEB-INF/templates/header.jsp"));
		attributes.put("menu", new Attribute("/WEB-INF/templates/menu.jsp"));
		attributes.put("footer", new Attribute("/WEB-INF/templates/footer.jsp"));
		
		return attributes;
	}
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false).favorParameter(true);
	}
	
	public static class JavaDefinitionsFactory extends UnresolvingLocaleDefinitionsFactory {

	    public JavaDefinitionsFactory() {
	    }

	    @Override
	    public Definition getDefinition(String name, Request tilesContext) {
	        return tiles.get(name);
	    }
	}
}
