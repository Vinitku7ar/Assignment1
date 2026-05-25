package com.example.assignment1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class OrdersAdapter(private var ordersList: List<Order>) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    // Update the list when searching or switching tabs
    fun updateList(newList: List<Order>) {
        ordersList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        // Assuming your item layout is named item_order_card.xml
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_card, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = ordersList[position]
        holder.bind(order)
    }

    override fun getItemCount(): Int = ordersList.size

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvVehicleType: TextView = itemView.findViewById(R.id.tv_vehicle_type)
        private val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        private val tvOrderDetails: TextView = itemView.findViewById(R.id.tv_order_details)
        private val tvPickup: TextView = itemView.findViewById(R.id.tv_pickup)
        private val tvDrop: TextView = itemView.findViewById(R.id.tv_drop)
        private val tvStatus: TextView = itemView.findViewById(R.id.tv_status)
        private val btnInvoice: Button = itemView.findViewById(R.id.btn_invoice)
        private val btnBookAgain: Button = itemView.findViewById(R.id.btn_book_again)

        fun bind(order: Order) {
            tvVehicleType.text = order.vehicleType
            tvPrice.text = "₹ ${order.price}"
            tvOrderDetails.text = "${order.dateString}  |  Order ID: ${order.orderId}"
            tvPickup.text = order.pickupLocation
            tvDrop.text = order.dropLocation
            tvStatus.text = order.status

            // Handle Button Clicks
            btnInvoice.setOnClickListener {
                Toast.makeText(itemView.context, "Downloading Invoice for ${order.orderId}", Toast.LENGTH_SHORT).show()
            }

            btnBookAgain.setOnClickListener {
                Toast.makeText(itemView.context, "Booking ${order.vehicleType} again!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}