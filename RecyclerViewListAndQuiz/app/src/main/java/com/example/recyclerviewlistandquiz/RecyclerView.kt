package com.example.recyclerviewlistandquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity(), ListAdapter.ItemClickListener {
    val products = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        supportActionBar?.title = "Electronics Category"
        products.add(Product("Fire 7 tablet", 41.99, "Black", R.drawable.product1, "ATVPDKIKX0DER", "7” display, 16 GB, 10 hours battery life, light and portable for entertainment at home or on-the-go, (2022 release), Black\n" +
                "Enhanced performance - up to 30% faster quad-core processor and 2 GB of RAM (double compared to Fire 7—9th generation).\n" +
                "7” touchscreen; 16 GB or 32GB of storage (add up to 1TB of expandable storage with microSD)."))
        products.add(Product("ASUS ROG Strix Scar 15 (2022) Gaming Laptop, 15.6” 300Hz IPS FHD Display", 1999.99, "Black", R.drawable.product2, "B09RMW1L7Y", "PEERLESS PROCESSING POWER - Speed through laptop gaming, streaming, and creating with the 12th Gen Intel Core i9-12900H Processor (6 P-cores and 8 E-cores) with 24M Cache and up to 5.0GHz clock speed.Aspect Ratio:16:9\n" +
                "RTX REALISM. IT’S ON - This Windows 11 gaming laptop is equipped with the GeForce RTX 3070 Ti laptop GPU with a max TGP of 150W and ROG Boost up to 1460MHz, to give you the most realistic ray-traced graphics and cutting-edge AI features like NVIDIA DLSS.\n" +
                "LIGHTNING FAST VISUALS - See everything with a swift 15.6” FHD/300Hz IPS type display and 3ms response time"))
        products.add(Product("ASUS ROG Flow Z13 (2022)", 1592.88, "Black", R.drawable.product3, "#B09RMPV211", "ULTIMATE VERSATILITY - Z13’s tablet form factor gives you the flexibility to follow your flow. Use the touchscreen with active stylus support for drawing and taking notes or attach the included keyboard for serious work and play.\n" +
                "FULL CONNECTIVITY - Blazing fast Wi-Fi 6E, Bluetooth 5.2, 1x Thunderbolt 4, 1x USB 3.2 Type-C (Gen2), 1x USB 2.0, 1x microSD (UHS-II)"))
        products.add(Product("Anker USB C Hub, PowerExpand 11-in-1 USB C Hub Adapter", 94.99, "Silver", R.drawable.product4, "B08NDGD2V5", "Huge 11-Port Expansion: Equipped with a USB-C Power Delivery input port, an HDMI port, a DisplayPort, 1 USB-C data port, 3 USB-A ports, 1 Ethernet port, an AUX port, an SD card slot, and a microSD card slot.\n" +
                "Multi-Monitor Display: The HDMI port and the DisplayPort both support a single-monitor display of up to 4K@60Hz. Connect to both simultaneously to enjoy crystal-clear streaming or mirroring across 2 displays at up to 2K@60Hz.\n" +
                "Transfer Files in Seconds: Connect your thumb drive or external hard drive to either the USB-C data port or the USB-A 3.0 port to transfer files at up to 5 Gbps.\n" +
                "What You Get: PowerExpand 11-in-1 USB-C PD Hub, travel pouch, welcome guide, 18-month warranty, and friendly customer service.\n" +
                "1 Gbps Ethernet, 3.5mm Audio, microSD and SD Card Reader"))
        products.add(Product("USB C Hub 4K HDMI 8-in-1 USBC", 24.99, "Blue", R.drawable.product5, "B0BG41XXV2", "USB C to 4K HDMI Hub: The usb c hub expands your screen through the HDMI port, giving you Ultra HD 4K images, showing content clearly and helping you to increase your productivity. Outside of work, it's also great for playing HD movies on your HDTV for an immersive viewing experience."))
        products.add(Product("Apple Magic Mouse (Wireless, Rechargable)", 74.00, "White", R.drawable.product6, "B09BRD98T4", "Magic Mouse is wireless and rechargeable, with an optimized foot design that lets it glide smoothly across your desk. The Multi-Touch surface allows you to perform simple gestures such as swiping between web pages and scrolling through documents."))
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ListAdapter(products, this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int) {
        val detailIntent = Intent(applicationContext, ProductDetail::class.java)
        detailIntent.putExtra("PRODUCT", products[position])
        startActivity(detailIntent)
    }
}