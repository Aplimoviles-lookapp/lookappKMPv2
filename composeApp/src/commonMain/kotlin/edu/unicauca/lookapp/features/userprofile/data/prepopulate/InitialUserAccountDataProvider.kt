package edu.unicauca.lookapp.features.userprofile.data.prepopulate

import edu.unicauca.lookapp.features.saved.data.entities.ItemEntity
import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity

object InitialUserAccountDataProvider {

    fun getAccounts(): List<UserAccountEntity> = listOf(
        UserAccountEntity(
            userAccountId = 0,
            name = "Freider",
            email = "freider@gmail.com",
            savedItems = listOf(
                ItemEntity(
                    itemId = 0,
                    title = "Caroy Peluqueria",
                    subtitle = "Corte de pelo",
                    imageUrl = "https://picsum.photos/201",
                ),
                ItemEntity(
                    itemId = 1,
                    title = "Peluqueria el calvo",
                    subtitle = "Shampoo",
                    imageUrl = "https://picsum.photos/201",
                ),
                ItemEntity(
                    itemId = 2,
                    title = "Peluqueria el calvo",
                    subtitle = "Corte de pelo",
                    imageUrl = "https://picsum.photos/201",
                ),
                ItemEntity(
                    itemId = 3,
                    title = "Salon de belleza",
                    subtitle = "Corte de pelo",
                    imageUrl = "https://picsum.photos/201",
                )
            )
        ),
        UserAccountEntity(
            name = "Naren",
            email = "naren@gmail.com",
            savedItems = emptyList()
        ),
        UserAccountEntity(
            name = "Ruben",
            email = "ruben@gmail.com",
            savedItems = emptyList()
        )
    )
}