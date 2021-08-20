package com.serasa.unit_test.model



import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserTest {

    @Test
    fun `valor de email é valido retorna false`() {
        val result = User("jorgemaria.com","aaa","123456","123456").validateUser()
        assertThat(result).isFalse()
    }

    @Test
    fun `valor de nome é valido retorna false`() {
        val result = User("jorgemaria@gmail.com","","123456","123456").validateUser()
        assertThat(result).isFalse()
    }

    @Test
    fun `valor de password é valido retorna false`() {
        val result = User("jorgemaria@gmail.com","aaaa","123456","1333456").validateUser()
        assertThat(result).isFalse()
    }

}