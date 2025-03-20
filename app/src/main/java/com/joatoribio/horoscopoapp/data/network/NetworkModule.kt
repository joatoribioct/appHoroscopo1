package com.joatoribio.horoscopoapp.data.network

import com.joatoribio.horoscopoapp.BuildConfig.BASE_URL
import com.joatoribio.horoscopoapp.data.ReposotyImpl
import com.joatoribio.horoscopoapp.data.core.interceptor.AuthInterceptor
import com.joatoribio.horoscopoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(OkHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(authInterceptor).build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopoApiService{
        return retrofit.create(HoroscopoApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopoApiService):Repository{
        return ReposotyImpl(apiService)
    }
}