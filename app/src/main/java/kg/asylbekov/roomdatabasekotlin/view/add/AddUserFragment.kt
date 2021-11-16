package kg.asylbekov.roomdatabasekotlin.view.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import kg.asylbekov.roomdatabasekotlin.R
import kg.asylbekov.roomdatabasekotlin.database.UserData
import kg.asylbekov.roomdatabasekotlin.databinding.FragmentAddUserBinding
import kg.asylbekov.roomdatabasekotlin.view.UsersViewModel

class AddUserFragment : Fragment() {
    private lateinit var viewModel: UsersViewModel
    private lateinit var b: FragmentAddUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentAddUserBinding.inflate(layoutInflater)
        viewModel = defaultViewModelProviderFactory.create(UsersViewModel::class.java)

        b.addbtn.setOnClickListener {
            addUser()
            findNavController().navigate(R.id.action_addUserFragment_to_listUsersFragment)
        }

        return b.root
    }

    private fun addUser() {
        val name = b.nameedit.text.toString()
        val age = b.ageedit.text
//        if(name.isNotEmpty() && age.isNotEmpty()){
            val user = UserData(id = 0, name = name, age = Integer.parseInt(age.toString()),1, "Mirbov", "YES","a")
            viewModel.addUser(user)
        println("aaaddd")
            Toast.makeText(context, "ADDED", Toast.LENGTH_SHORT).show()
//        }else{
            Toast.makeText(context, "PLEASE ADD DATA", Toast.LENGTH_SHORT).show()
//        }
         }
}