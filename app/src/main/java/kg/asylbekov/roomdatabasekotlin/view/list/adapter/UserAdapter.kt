package kg.asylbekov.roomdatabasekotlin.view.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.roomdatabasekotlin.database.UserData
import kg.asylbekov.roomdatabasekotlin.databinding.UserItemBinding
import kg.asylbekov.roomdatabasekotlin.view.list.ListUsersFragmentDirections
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(private val onOn: (UserData) -> Unit) : RecyclerView.Adapter<UserAdapter.UserVH>() {
    private var list = emptyList<UserData>()

    fun setUser(list:List<UserData>){
    this.list = list
        notifyDataSetChanged()
    }
   inner class UserVH(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: UserData) {

            itemView.userid.text = user.id.toString()
            itemView.name.text = user.name.toString()
            itemView.age.text = user.age.toString()

            val userq = list[position]
            itemView.userid.setOnClickListener {
                val action = ListUsersFragmentDirections.actionListUsersFragmentToUpdateFragment(userq)
                itemView.findNavController().navigate(action)

            }

            itemView.setOnClickListener {
                onOn(userq)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserVH(binding)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}