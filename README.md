# Rick And Morty App
<p>🇧🇷 Aplicativo com tema do Rick and Morty, interatividade com seleção aleatória de personagens e listas, são 826 personagens que podem ser vistos na tela de detalhes e 42 listas com vários personagens da série, veja os detalhes de cada um deles e descubra curiosidades sobre todos eles! Ahhh mas eu não quero sortear uma lista ou um personagem, eu gostaria de passar por todos eles e olhar as curiosidades... Você pode, basta clicar no botão "Just navigate" na tela de menu das listas, ele irá te levar para a primeira página e você poderá paginar entre as 42 páginas, indo e voltando da maneira que quiser!</p>

<p>🇺🇸 Application with the theme of Rick and Morty, interactivity with random selection of characters and lists, are 826 characters that can be seen on the details screen and 42 lists with various characters from the series, see the details of each of them and discover curiosities about them all! Ahhh but I don't want to random a list or a character, I would like to go through them all and look at the curiosities... You can, just click on the "Just navigate" button on the menu screen of the lists, it will take you to the first page and you can scroll between the 42 pages, going back and forth as you like!</p>

Link to the api documentation: https://rickandmortyapi.com/

# Technology / Others

- Couroutines
- JetPack Navigation Component
- Koin
- View Model
- RecyclerView
- Retrofit
- Live Data
- Core splashscreen
- MVVM
- Fragments

# About the api / Sobre a api

Link to the api documentation: https://rickandmortyapi.com/

### I used the following routes:

To get a single character with id:
- https://rickandmortyapi.com/api/character/(value id)

I used this method to get a specify character:
```
@GET("character/{id}")
    suspend fun getSingleCharacter(
        @Path("id") id: String
    ): SingleCharacter
```

To get a list of characters, you need to specify the page number... Case you don't specify the api will give to you just first page. :
- https://rickandmortyapi.com/api/character (just a first page)
- https://rickandmortyapi.com/api/character/?page=2 (will bring up page 2)

I used this method to get a specify list:
```
@GET("character/")
    suspend fun getListCharacter(
        @Query("page") page: String
    ): ListCharacterResponse
```

# Curiosities / Curiosidades

### I would like to show a very cool curiosity about one of the items returned in the api object

The character's life status can be returned in 3 different strings Alive, Dead, Unknown... 
To validate this point, I created a class that sends a ready-made object with the colors, texts, and the image that should appear on the screen...

```
enum class StatusCharacter(
    @StringRes val status: Int,
    @ColorRes val textColor: Int,
    @DrawableRes val iconImg: Int,
) {
    STATUS_ALIVE(
        status = R.string.txt_status_alive,
        textColor = Color.GREEN,
        iconImg = R.drawable.alive_status
    ),

    STATUS_DEAD(
        status = R.string.txt_status_dead,
        textColor = Color.RED,
        iconImg = R.drawable.dead_status
    ),

    STATUS_UNKNOWN(
        status = R.string.txt_status_unknown,
        textColor = Color.GRAY,
        iconImg = R.drawable.unknow_status
    )
}

```
# The Nav Graph

![my_nav_graph](https://user-images.githubusercontent.com/85715073/150380485-f13d23a3-3b04-4124-bbe1-6ab6b739734f.png)


# The beta version app / A versão beta do app

## *Success*

### *Splash screen and home*

https://user-images.githubusercontent.com/85715073/150377038-bee95feb-29b6-485b-a3ad-4ef0624ac6aa.mp4

### *Random single character*

https://user-images.githubusercontent.com/85715073/150377307-de739ccf-2531-4d36-a612-10b4acadd203.mp4

### *Type number to get a single character*

https://user-images.githubusercontent.com/85715073/150377436-83fe9f23-3471-4532-8012-62fb9a333d9d.mp4

### *Random list of the characters*

https://user-images.githubusercontent.com/85715073/150377581-f6be5ce9-58ea-44c8-909f-2c6b7dac61cb.mp4

### *Just navigate between pages*

https://user-images.githubusercontent.com/85715073/150377702-fcaf34b7-633b-4146-bd27-47dfba1ea610.mp4

## *Error tratament*

### *The number you entered is incorrect*

https://user-images.githubusercontent.com/85715073/150379172-06098543-f3d9-44ef-9949-e2af130de401.mp4

### *Details Exception*

https://user-images.githubusercontent.com/85715073/150379385-dade622f-c34e-4669-9be8-48c139d57e91.mp4

### *List Exception*

https://user-images.githubusercontent.com/85715073/150379443-52fb047e-b913-4070-b517-2f9ec3d2f222.mp4


