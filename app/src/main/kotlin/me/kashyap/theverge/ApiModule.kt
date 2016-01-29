package me.kashyap.theverge

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import me.kashyap.theverge.rest.RssService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.RxJavaCallAdapterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created on 3/23/2015.
 */

const val BASE_URL = "BASE_URL"

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesRestAdapter(@Named(BASE_URL) baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        var client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
        .build()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(converterFactory)
                .build()
    }

    @Singleton
    @Provides
    fun providesRssService(adapter: Retrofit): RssService {
        return adapter.create(RssService::class.java)
    }

    @Provides
    @Singleton
    fun providesPicasso(context: Context): Picasso {
        return Picasso.with(context.applicationContext)
    }
}

