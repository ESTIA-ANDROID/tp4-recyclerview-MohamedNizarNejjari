package com.openclassrooms.magicgithub.ui.user_list

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback
import java.util.*

class UserListAdapter(private val callback: Listener) :
    RecyclerView.Adapter<UserListAdapter.ListUserViewHolder>() {

    private var users: MutableList<User> = mutableListOf()

    interface Listener {
        fun onClickDelete(user: User)
    }

    inner class ListUserViewHolder(val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        val user = users[position]

        holder.binding.userNameTextView.text = user.name
        Glide.with(holder.binding.userAvatarImageView.context)
            .load(user.avatarUrl)
            .circleCrop()
            .into(holder.binding.userAvatarImageView)

        holder.binding.root.setBackgroundColor(if (user.isActive) Color.WHITE else Color.RED)

        holder.binding.itemListUserDeleteButton.setOnClickListener {
            Log.d("DeleteUser", "Tentative de suppression de ${user.name}") // DEBUG
            callback.onClickDelete(user)
        }
    }

    override fun getItemCount(): Int = users.size

    fun updateUsers(newUsers: List<User>) {
        Log.d("AdapterUpdate", "Mise à jour de la liste, nouvelle taille : ${newUsers.size}") // ✅ DEBUG
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged() // 🚀 Force la mise à jour de la RecyclerView
    }




    val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val fromPosition = viewHolder.adapterPosition
            val toPosition = target.adapterPosition

            Collections.swap(users, fromPosition, toPosition)
            notifyItemMoved(fromPosition, toPosition)

            return true
        }


        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            users[position].isActive = !users[position].isActive
            notifyItemChanged(position) // Assure que l'élément est bien mis à jour
        }

    })
}
