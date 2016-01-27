package me.kashyap.theverge;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.kashyap.theverge.rest.RssService;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.converter.Converter;

/**
 * Created on 3/23/2015.
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    public RestAdapter providesRestAdapter(Converter converter, Endpoint endpoint) {
        return new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.BASIC)
                .setEndpoint(endpoint)
                .setConverter(converter)
                .build();
    }

    @Singleton
    @Provides
    public RssService providesRssService(RestAdapter adapter) {
        return adapter.create(RssService.class);
    }

    @Provides
    @Singleton
    public Picasso providesPicasso(Context context) {
        return Picasso.with(context.getApplicationContext());
    }
}

