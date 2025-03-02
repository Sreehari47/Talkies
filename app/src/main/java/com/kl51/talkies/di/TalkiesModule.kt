package com.kl51.talkies.di

import androidx.lifecycle.ViewModel
import com.kl51.talkies.network.MovieApi
import com.kl51.talkies.utils.ViewModelKey
import com.kl51.talkies.view.MainActivity
import com.kl51.talkies.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module
abstract class TalkiesModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun providesMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun providesMainActivityViewModel(weatherViewModel: MainActivityViewModel): ViewModel
}
