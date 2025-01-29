package com.openclassrooms.magicgithub.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback
import android.util.Log
import com.bumptech.glide.Glide


class UserListAdapter(  // FOR CALLBACK ---
    private val callback: Listener
) : RecyclerView.Adapter<ListUserViewHolder>() {
    // FOR DATA ---
    private var users: List<User> = ArrayList()

    interface Listener {
        fun onClickDelete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_list_user, parent, false)
        return ListUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        val user = users[position]

        // Vérification des URLs des images
        Log.d("UserAdapter", "Chargement de l'image pour ${user.name}: ${user.avatarUrl}")

        holder.userNameTextView.text = user.name

        // Charger l'image avec Glide
        Glide.with(holder.itemView.context)
            .load(user.avatarUrl)
            .placeholder(android.R.drawable.ic_menu_gallery) // Image de chargement par défaut
            .error(android.R.drawable.ic_menu_close_clear_cancel) // Image si erreur
            .into(holder.userAvatarImageView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    // PUBLIC API ---
    fun updateList(newList: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffCallback(newList, users))
        users = newList
        diffResult.dispatchUpdatesTo(this)
    }
}