package com.openclassrooms.magicgithub.ui.user_list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.model.User

class ListUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val userNameTextView: TextView = itemView.findViewById(R.id.userNameTextView)
    val userAvatarImageView: ImageView = itemView.findViewById(R.id.userAvatarImageView)

    fun bind(user: User) {
        userNameTextView.text = user.name
    }
}
