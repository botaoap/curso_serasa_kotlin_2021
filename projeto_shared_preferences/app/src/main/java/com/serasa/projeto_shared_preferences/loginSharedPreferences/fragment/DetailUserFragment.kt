package com.serasa.projeto_shared_preferences.loginSharedPreferences.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.serasa.projeto_shared_preferences.R
import com.serasa.projeto_shared_preferences.loginSharedPreferences.model.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailUserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailUserFragment : Fragment() {

    private lateinit var idTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var firstNameTextView: TextView
    private lateinit var lastNameTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var cityTextView: TextView
    private lateinit var streetNameTextView: TextView
    private lateinit var numberNameTextView: TextView
    private lateinit var zipCodeNameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_user, container, false)
    }

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idTextView = view.findViewById(R.id.textViewId)
        emailTextView = view.findViewById(R.id.textViewEmail)
        firstNameTextView = view.findViewById(R.id.textViewFirstname)
        lastNameTextView = view.findViewById(R.id.textViewLastName)
        phoneTextView = view.findViewById(R.id.textViewPhone)
        cityTextView = view.findViewById(R.id.textViewCity)
        streetNameTextView = view.findViewById(R.id.textViewStreet)
        numberNameTextView = view.findViewById(R.id.textViewNumber)
        zipCodeNameTextView = view.findViewById(R.id.textViewZipCode)


        val preferences =
            requireActivity().getSharedPreferences("minha_preference", Context.MODE_PRIVATE)
        idTextView.text = preferences.getString("key_id", "")
        emailTextView.text = preferences.getString("key_email", "")
        firstNameTextView.text = preferences.getString("key_firstname", "")
        lastNameTextView.text = preferences.getString("key_lastname", "")
        phoneTextView.text = preferences.getString("key_phone", "")
        cityTextView.text = preferences.getString("key_city", "")
        streetNameTextView.text = preferences.getString("key_street", "")
        numberNameTextView.text = preferences.getString("key_number", "")
        zipCodeNameTextView.text = preferences.getString("key_zipcode", "")

    }


}