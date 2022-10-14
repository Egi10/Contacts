package id.buja.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import id.buja.contacts.model.Contact

class MainAdapter(private val list: List<Contact>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: MaterialTextView
        val description: MaterialTextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            title = view.findViewById(R.id.tv_title)
            description = view.findViewById(R.id.tv_description)
            imageView = view.findViewById(R.id.iv_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_contacts, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = list[position]

        with(holder) {
            title.text = items.title
            description.text = items.description
            imageView.setImageResource(items.image)
        }
    }

    override fun getItemCount() = list.size
}

