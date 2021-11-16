package kg.asylbekov.roomdatabasekotlin.view.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kg.asylbekov.roomdatabasekotlin.R
import kg.asylbekov.roomdatabasekotlin.database.UserData
import kg.asylbekov.roomdatabasekotlin.databinding.FragmentUpdateBinding
import kg.asylbekov.roomdatabasekotlin.view.UsersViewModel
import kotlinx.android.synthetic.main.fragment_update.*

class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var binding : FragmentUpdateBinding
    private lateinit var vm : UsersViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        vm = defaultViewModelProviderFactory.create(UsersViewModel::class.java)
        binding.nameup.setText(args.currentUser.name)
        binding.ageup.setText(args.currentUser.age.toString())
        binding.upbtn.setOnClickListener {
            val name = binding.nameup.text.toString()
            val age = binding.ageup.text
            val user = UserData(args.currentUser.id, name = name, age = Integer.parseInt(age.toString()),1, "a", "a", "a")
            vm.updateUser(user)
            findNavController().navigate(R.id.action_updateFragment_to_listUsersFragment)
        }
        binding.buttondelete.setOnClickListener {
            vm.deleteUser(args.currentUser)
            findNavController().navigate(R.id.action_updateFragment_to_listUsersFragment)

        }

        return binding.root
    }
}