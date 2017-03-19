package com.sixtyfourthpixel.buzzardweather.di;


import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {
	private final String baseUrl;

	public NetModule(String mBaseUrl) {
		this.baseUrl = mBaseUrl;
	}

	@Provides
	@Singleton
	Cache provideHttpCache(Application application) {
		int cacheSize = 10 * 1024 * 1024;
		return new Cache(application.getCacheDir(), cacheSize);
	}

	@Provides
	@Singleton
	Gson provideGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		return gsonBuilder.create();
	}

	@Provides
	@Singleton
	OkHttpClient provideOkhttpClient(Cache cache) {
		OkHttpClient.Builder client = new OkHttpClient.Builder();
		client.cache(cache);
		return client.build();
	}

	@Provides
	@Singleton
	Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
		return new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create(gson))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.baseUrl(baseUrl)
				.client(okHttpClient)
				.build();
	}

	@Provides
	@Singleton
	OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient client) {
		return new OkHttp3Downloader(client);
	}

	@Provides
	@Singleton
	Picasso providePicasso(Application application, OkHttp3Downloader okHttp3Downloader) {
		return new Picasso.Builder(application).downloader(okHttp3Downloader).build();
	}
}
