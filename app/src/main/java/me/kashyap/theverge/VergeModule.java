package me.kashyap.theverge;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.converter.Converter;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created on 3/23/2015.
 */
@Module(includes = ApiModule.class)
public class VergeModule {

    //http://www.theverge.com/rss/index.xml
    @Provides
    public Endpoint provideEndPoint() {
        return Endpoints.newFixedEndpoint("http://www.theverge.com/");
    }

    @Provides
    public Converter providesConverter() {
        return new SimpleXMLConverter();
    }
}
