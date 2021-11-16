package kg.asylbekov.roomdatabasekotlin.modules

import kg.asylbekov.roomdatabasekotlin.database.UserDao
import kg.asylbekov.roomdatabasekotlin.database.UserDataBase
import kg.asylbekov.roomdatabasekotlin.repo.UserRepository
import kg.asylbekov.roomdatabasekotlin.view.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val databaseModule = module {
    single { UserDataBase }
}
val   userViewModel = module {
    viewModel {UsersViewModel(get())}
    single { UserRepository(get()) }
}
