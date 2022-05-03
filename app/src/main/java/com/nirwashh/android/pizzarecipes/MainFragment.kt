package com.nirwashh.android.pizzarecipes

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nirwashh.android.pizzarecipes.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    lateinit var b: FragmentMainBinding
    lateinit var fm: FragmentManager
    lateinit var list: ArrayList<ListItem>
    lateinit var adapter: MyAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fm = (context as FragmentActivity).supportFragmentManager
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.slide_right)
        enterTransition = inflater.inflateTransition(R.transition.slide_out_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentMainBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList()
        list.addAll(fillArrays(resources.getStringArray(R.array.recipe_name),
            resources.getStringArray(R.array.recipe_description),
            getImageId(R.array.recipe_image)))

        adapter = MyAdapter(list, requireContext())
        b.apply {
            recyclerView.adapter = adapter
            recyclerView.hasFixedSize()
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

        }


    }

    //объединяем 3 массива с данными в один
    fun fillArrays(titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray ): ArrayList<ListItem> {
        val listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices) {
            val listItem = ListItem(titleArray[n], contentArray[n], imageArray[n] )
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    //получаем массив image id
    fun getImageId(imageArrayId: Int): IntArray {
        val tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val ids = IntArray(tArray.length())
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

}