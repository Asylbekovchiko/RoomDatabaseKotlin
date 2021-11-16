package kg.asylbekov.roomdatabasekotlin.view.list

import android.content.Intent
import android.os.Bundle
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.roomdatabasekotlin.R
import kg.asylbekov.roomdatabasekotlin.databinding.FragmentListUsersBinding
import kg.asylbekov.roomdatabasekotlin.view.UsersViewModel
import kg.asylbekov.roomdatabasekotlin.view.list.adapter.UserAdapter
import kotlinx.android.synthetic.main.fragment_list_users.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.user_item.*

class ListUsersFragment : Fragment() {
    private lateinit var b: FragmentListUsersBinding
    private lateinit var adapter : UserAdapter
    private lateinit var viewModel: UsersViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        b = FragmentListUsersBinding.inflate(layoutInflater)
            b.floatingActionButton.setOnClickListener {
        findNavController().navigate(R.id.action_listUsersFragment_to_addUserFragment)
        }
        viewModel = defaultViewModelProviderFactory.create(UsersViewModel::class.java)
        adapter = UserAdapter {
        }


        b.recc.adapter = adapter
        viewModel.getAllUsers.observe(requireActivity(), Observer {
        adapter.setUser(it)
        })

        // Inflate the layout for this fragment
        return b.root
    } }