package com.serasa.projeto_shared_preferences.loginSharedPreferences.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.serasa.projeto_shared_preferences.MainActivity
import com.serasa.projeto_shared_preferences.R
import com.serasa.projeto_shared_preferences.loginSharedPreferences.extensions.snackBar
import com.serasa.projeto_shared_preferences.loginSharedPreferences.model.User
import com.serasa.projeto_shared_preferences.loginSharedPreferences.serviceApi.RetrofitBuilder
import com.serasa.projeto_shared_preferences.loginSharedPreferences.ui.MainLoginActivity
import com.serasa.projeto_shared_preferences.ui.main.MainViewModel
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), Callback<User> {
    // TODO: Rename and change types of parameters
    private lateinit var inputUser : EditText
    private lateinit var inputPws: EditText
    private lateinit var buttonLogin: Button
    private lateinit var preferences: SharedPreferences
    private lateinit var viewModel: ViewModel
    private var user: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Inicializa preference
        preferences = requireActivity().getSharedPreferences("minha_preference", Context.MODE_PRIVATE)

        // TODO: Load components of Screen
        inputUser = view.findViewById(R.id.inputTextFieldUsername)
        inputPws = view.findViewById(R.id.inputTextFieldPassword)
        buttonLogin = view.findViewById(R.id.buttonLogin)

        sharedPreference()
        buttonLogin.apply {
            setOnClickListener {
                if (validaCampoLogin()){
                    preferences.edit {
                        putString("chave_username", inputUser.text.toString())
                        commit()
                    }
                    connectApi()
                }else {
                    (requireActivity() as MainLoginActivity).snackBar(inputUser, R.string.user_invalid)
                }
            }
        }
    }

    private fun sharedPreference() {

        val usernameSharedPreferences = preferences.getString("chave_username", "")
        if (!usernameSharedPreferences.isNullOrEmpty()){
            inputUser.setText(usernameSharedPreferences)
        }
    }

    private fun validaCampoLogin() : Boolean {
        val user = inputUser.text.toString()
        val pws = inputPws.text.toString()

        return user.isNotEmpty() && pws.isNotEmpty()
    }

    private fun connectApi() {
        RetrofitBuilder
            .getConnectionFakeApi()
            .getOneUser()
            .clone()
            .enqueue(this)
    }

    override fun onResponse(response: Response<User>?, retrofit: Retrofit?) {
        println("Sucesso na Conexao")

        response?.body()?.apply {
            user = this
            if (inputUser.text.toString() == this.username) {
                (requireActivity() as? MainLoginActivity)?.replaceFrag(DetailUserFragment())
                preferences.edit {
                    putString("key_id", user?.id.toString())
                    putString("key_email", user?.email.toString())
                    putString("key_firstname", user?.name?.firstname.toString())
                    putString("key_lastname", user?.name?.lastname.toString())
                    putString("key_phone", user?.phone.toString())
                    putString("key_city", user?.address?.city.toString())
                    putString("key_street", user?.address?.street.toString())
                    putString("key_number", user?.address?.number.toString())
                    putString("key_zipcode", user?.address?.zipCode.toString())
                }

            } else {
                (requireActivity() as MainLoginActivity).snackBar(inputUser, R.string.user_invalid)
            }
        }
    }

    override fun onFailure(t: Throwable?) {
        println("Falha na Conexao")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }
}