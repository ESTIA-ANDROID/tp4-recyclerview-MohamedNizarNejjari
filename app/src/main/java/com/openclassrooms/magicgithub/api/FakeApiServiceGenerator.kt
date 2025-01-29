package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User

object FakeApiServiceGenerator {

    @JvmField
    val FAKE_USERS = listOf(
        User(1, "Jake", "https://randomuser.me/api/portraits/men/1.jpg"),
        User(2, "Paul", "https://randomuser.me/api/portraits/men/2.jpg"),
        User(3, "Phil", "https://randomuser.me/api/portraits/men/3.jpg"),
        User(4, "Guillaume", "https://randomuser.me/api/portraits/men/4.jpg"),
        User(5, "Francis", "https://randomuser.me/api/portraits/men/5.jpg"),
        User(6, "George", "https://randomuser.me/api/portraits/men/6.jpg"),
        User(7, "Louis", "https://randomuser.me/api/portraits/men/7.jpg"),
        User(8, "Mateo", "https://randomuser.me/api/portraits/men/8.jpg"),
        User(9, "April", "https://randomuser.me/api/portraits/men/9.jpg"),
        User(10, "Louise", "https://randomuser.me/api/portraits/men/10.jpg"),
        User(11, "Elodie", "https://randomuser.me/api/portraits/men/11.jpg"),
        User(12, "Helene", "https://randomuser.me/api/portraits/men/12.jpg"),
        User(13, "Fanny", "https://randomuser.me/api/portraits/men/13.jpg"),
        User(14, "Laura", "https://randomuser.me/api/portraits/men/14.jpg"),
        User(15, "Gertrude", "https://randomuser.me/api/portraits/men/15.jpg"),
        User(16, "Chloé", "https://randomuser.me/api/portraits/men/16.jpg"),
        User(17, "April", "https://randomuser.me/api/portraits/men/17.jpg"),
        User(18, "Marie", "https://randomuser.me/api/portraits/men/18.jpg"),
        User(19, "Henri", "https://randomuser.me/api/portraits/men/19.jpg"),
        User(20, "Rémi", "https://randomuser.me/api/portraits/men/20.jpg")
    )

    @JvmField
    val FAKE_USERS_RANDOM = listOf(
        User(21, "Lea", "https://randomuser.me/api/portraits/men/21.jpg"),
        User(22, "Geoffrey", "https://randomuser.me/api/portraits/men/22.jpg"),
        User(23, "Simon", "https://randomuser.me/api/portraits/men/23.jpg"),
        User(24, "André", "https://randomuser.me/api/portraits/men/24.jpg"),
        User(25, "Leopold", "https://randomuser.me/api/portraits/men/25.jpg")
    )
}