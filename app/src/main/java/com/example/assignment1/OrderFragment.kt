package com.example.assignment1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment1.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayout


/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
// DataBinding
    private var _binding: FragmentOrderBinding? = null


    private val binding get() = _binding!!

    private lateinit var ordersAdapter: OrdersAdapter
    private var allOrders: List<Order> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDummyData()
        setupRecyclerView()
        setupTabs()
        setupSearch()
        setupClickListeners()
    }
    private fun setupDummyData() {
        allOrders = listOf(
            Order("#ORD12345", "Four Wheeler", "05 Feb, 4:46 PM", 229.0, "741, Gumanwara", "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh", "CANCELLED"),
            Order("#ORD12346", "Four Wheeler", "05 Feb, 4:46 PM", 229.0, "741, Gumanwara", "00, Main Rd, Shivaji Nagar, Jhansi, Uttar Pradesh", "CANCELLED"),
            Order("#ORD12347", "Four Wheeler", "05 Feb, 4:46 PM", 1515.0, "332, Gumanwara", "GC72+GGV, Kamrari, Madhya Pradesh", "CANCELLED"),
            Order("#ORD12348", "Four Wheeler", "05 Feb, 4:46 PM", 1634.0, "332, Gumanwara", "GC72+GGV, Kamrari, Madhya Pradesh", "COMPLETED")
        )
    }

    private fun setupRecyclerView() {
        ordersAdapter = OrdersAdapter(allOrders)
        // Access RecyclerView directly via binding
        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOrders.adapter = ordersAdapter
    }

    private fun setupTabs() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                filterOrders()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setupSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterOrders()
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterOrders() {
        val query = binding.etSearch.text.toString().lowercase()
        val selectedTabPosition = binding.tabLayout.selectedTabPosition

        val filteredList = allOrders.filter { order ->
            // Search Match
            val matchesSearch = order.orderId.lowercase().contains(query) ||
                    order.pickupLocation.lowercase().contains(query) ||
                    order.dropLocation.lowercase().contains(query)

            // Tab Match
            val matchesTab = when (selectedTabPosition) {
                0 -> true // All Orders
                1 -> order.status == "COMPLETED"
                2 -> order.status == "CANCELLED"
                3 -> true // Booked Again logic
                else -> true
            }

            matchesSearch && matchesTab
        }

        ordersAdapter.updateList(filteredList)
    }

    private fun setupClickListeners() {
        // Close
        binding.ivCloseBanner.setOnClickListener {
            binding.infoBanner.visibility = View.GONE
        }

        // Help FAB
        binding.fabHelp.setOnClickListener {
            Toast.makeText(requireContext(), "Opening Help & Support", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }


    }

