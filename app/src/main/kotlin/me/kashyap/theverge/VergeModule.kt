package me.kashyap.theverge

import dagger.Module

import dagger.Provides
import retrofit2.Converter
import retrofit2.SimpleXmlConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created on 3/23/2015.
 */
@Module(includes = arrayOf(ApiModule::class))
class VergeModule {

    //http://www.theverge.com/rss/index.xml
    @Singleton
    @Provides
    @Named(BASE_URL)
    fun provideEndPoint(): String  {
        return "http://www.theverge.com/"
    }

    @Singleton
    @Provides
    fun provideSimpleXmlFactory() : Converter.Factory {
        return SimpleXmlConverterFactory.create()
    }
}
