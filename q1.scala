package practical_8

import scala.io.StdIn.readLine

object q1 {

  // Function to encrypt the text using Caesar cipher
  def caesarEncrypt(plaintext: String, shift: Int): String = {
    plaintext.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isLower) 'a' else 'A'
        ((char - shiftBase + shift) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }

  // Generic function for encryption using a provided cipher function
  def Encrypt(text: String, shift: Int, cipherFunction: (String, Int) => String): String = {
    cipherFunction(text, shift)
  }

  // Generic function for decryption using a provided cipher function
  def Decrypt(ciphertext: String, shift: Int, cipherFunction: (String, Int) => String): String = {
    cipherFunction(ciphertext, 26 - shift)
  }

  def main(args: Array[String]): Unit = {
    println("Enter a string:")
    val plaintext = readLine()
    println("Enter shift value:")
    val shiftValue = readLine().toInt

    // Encryption
    val encryptedText = Encrypt(plaintext, shiftValue, caesarEncrypt)
    println("Encrypted: " + encryptedText)

    // Decryption
    val decryptedText = Decrypt(encryptedText, shiftValue, caesarEncrypt)
    println("Decrypted: " + decryptedText)
  }
}
