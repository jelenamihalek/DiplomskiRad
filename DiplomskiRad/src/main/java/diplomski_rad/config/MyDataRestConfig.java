package diplomski_rad.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import diplomski_rad.models.AuthorModel;
import diplomski_rad.models.BookModel;
import diplomski_rad.models.GenreModel;
import diplomski_rad.models.PublisherModel;
import diplomski_rad.models.ReviewModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[]theUnsupporterActionsHttpMethods= {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};

		config.getExposureConfiguration()
		.forDomainType(GenreModel.class).
			withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods))
				.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods));
		
		config.getExposureConfiguration()
			.forDomainType(BookModel.class).
				withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods))
					.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods));
		
		config.getExposureConfiguration()
		.forDomainType(ReviewModel.class).
			withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods))
				.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods));
		
		config.getExposureConfiguration()
		.forDomainType(AuthorModel.class).
			withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods))
				.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods));
		
		config.getExposureConfiguration()
		.forDomainType(PublisherModel.class).
			withItemExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods))
				.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupporterActionsHttpMethods));
		
		//exposeids
		
		exposeIds(config);
	}
	
	private void exposeIds(RepositoryRestConfiguration config) {
		
		Set<EntityType<?>>entities=entityManager.getMetamodel().getEntities();
		
		List<Class> entityClasses=new ArrayList<>();
		
		for(EntityType temPEntityType : entities) {
			entityClasses.add(temPEntityType.getJavaType());
		}
		
		Class[]domainTypes=entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
}
