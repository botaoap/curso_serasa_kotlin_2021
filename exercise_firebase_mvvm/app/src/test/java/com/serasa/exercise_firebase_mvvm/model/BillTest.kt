package com.serasa.exercise_firebase_mvvm.model



import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BillTest {

    @Test
    fun `valor é maior que zero retonar false`() {
        val result = Bill(null,"",price = -10.0).validarBill()
        assertThat(result).isFalse()
    }

    @Test
    fun `valor é maior que zero retonar true`() {
        val result = Bill(null,"",price = 10.0).validarBill()
        assertThat(result).isTrue()
    }

    @Test
    fun `valor é null retonar false`() {
        val result = Bill(null,"",null).validarBill()
        assertThat(result).isFalse()
    }
}