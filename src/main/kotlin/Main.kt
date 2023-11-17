fun main() {
    val alphabet = listOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М',
        'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь',
        'Ы', 'Ъ', 'Э', 'Ю', 'Я'
    )

    println("Выберите действие: ")
    println("1. Зашифровать текст")
    println("2. Расшифровать текст")
    val action = readLine()?.toIntOrNull()

    when (action) {
        1 -> {
            println("Введите исходный текст:")
            val plaintext = readLine()?.toUpperCase()
            println("Введите ключевое слово:")
            val keyword = readLine()?.toUpperCase()

            val encryptedText = encryptText(plaintext, keyword, alphabet)
            println("Зашифрованный текст: $encryptedText")
        }
        2 -> {
            println("Введите зашифрованный текст:")
            val encryptedText = readLine()?.toUpperCase()
            println("Введите ключевое слово:")
            val keyword = readLine()?.toUpperCase()

            val decryptedText = decryptText(encryptedText, keyword, alphabet)
            println("Расшифрованный текст: $decryptedText")
        }
        else -> println("Некорректный ввод.")
    }
}

fun encryptText(plaintext: String?, keyword: String?, alphabet: List<Char>): String {
    if (plaintext == null || keyword == null) return ""

    val encryptedChars = plaintext.mapIndexed { index, char ->
        val keywordIndex = index % keyword.length
        val shift = keyword[keywordIndex].toInt() - 'А'.toInt()
        val encryptedIndex = (alphabet.indexOf(char) + shift) % alphabet.size
        alphabet[encryptedIndex]
    }
    return encryptedChars.joinToString("")
}

fun decryptText(encryptedText: String?, keyword: String?, alphabet: List<Char>): String {
    if (encryptedText == null || keyword == null) return ""

    val decryptedChars = encryptedText.mapIndexed { index, char ->
        val keywordIndex = index % keyword.length
        val shift = keyword[keywordIndex].toInt() - 'А'.toInt()
        val decryptedIndex = (alphabet.indexOf(char) - shift + alphabet.size) % alphabet.size
        alphabet[decryptedIndex]
    }
    return decryptedChars.joinToString("")
}