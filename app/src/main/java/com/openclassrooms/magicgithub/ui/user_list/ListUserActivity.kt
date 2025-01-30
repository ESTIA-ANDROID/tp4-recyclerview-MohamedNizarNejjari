package com.openclassrooms.magicgithub.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.openclassrooms.magicgithub.api.FakeApiService
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.repository.UserRepository

class ListUserActivity : AppCompatActivity(), UserListAdapter.Listener {

    private lateinit var binding: ActivityListUserBinding
    private lateinit var adapter: UserListAdapter
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisation du ViewBinding
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = FakeApiService()
        userRepository = UserRepository(apiService)
        adapter = UserListAdapter(this) // Passe `this` comme Listener

        binding.activityListUserRv.layoutManager = LinearLayoutManager(this)
        binding.activityListUserRv.adapter = adapter
        adapter.updateUsers(userRepository.getUsers())

        // Attacher le ItemTouchHelper pour gérer le swipe et le drag & drop
        adapter.itemTouchHelper.attachToRecyclerView(binding.activityListUserRv)
    }

    override fun onClickDelete(user: User) { // ✅ En dehors de `onCreate()`
        Log.d("DeleteUser", "Suppression de ${user.name}")
        userRepository.deleteUser(user)
        adapter.updateUsers(userRepository.getUsers())
    }
}
