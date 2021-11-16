package kg.asylbekov.roomdatabasekotlin.app

import android.app.Application
import kg.asylbekov.roomdatabasekotlin.modules.databaseModule
import kg.asylbekov.roomdatabasekotlin.modules.userViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppModule: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppModule)
            modules(listOf(
                databaseModule,
                userViewModel
            ))
        }
    }
}
