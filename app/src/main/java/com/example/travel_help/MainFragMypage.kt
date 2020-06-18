package com.example.travel_help

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_frag_msg.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [main_frag_msg.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [main_frag_msg.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFragMypage : Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    //리사이클러뷰 더미데이터
    val mypageList = arrayListOf<DataClassMypage>(
        DataClassMypage("비밀번호 변경"),
        DataClassMypage("회원탈퇴")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var rootview1 : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootview = inflater.inflate(R.layout.main_frag_mypage, container, false)


        //리사이클러뷰 어댑터
        val intent = Intent(requireContext(), BoardActivity::class.java)
        val mAdapter = MainFragMypageRvAdapter(requireContext(), mypageList) {
            //msg ->intent.putExtra("title", msg.)
            //startActivity(intent)

        }


        rootview1 = rootview.findViewById(R.id.mypage_rv!!)as RecyclerView
        rootview1.layoutManager = LinearLayoutManager(requireContext())
        rootview1.adapter = mAdapter

        return rootview
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}
