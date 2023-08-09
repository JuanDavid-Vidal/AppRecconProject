package com.rojasdev.apprecconproject.viewHolders

import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.rojasdev.apprecconproject.R
import com.rojasdev.apprecconproject.controller.price
import com.rojasdev.apprecconproject.data.dataModel.allCollecionAndCollector
import com.rojasdev.apprecconproject.databinding.ItemRvAllRecolectionDateBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class viewHolderItemDate( var view: View ): RecyclerView.ViewHolder(view) {

    private val binding = ItemRvAllRecolectionDateBinding.bind(view)

    fun render (
        itemDetail: allCollecionAndCollector
    ) {

        binding.cvCollectionDetail.animation = AnimationUtils.loadAnimation(view.context, R.anim.recycler_transition)

        val getDate = itemDetail.Fecha
        val formatDate = "EEEE, MMMM dd 'del' yyyy 'Hora: ' HH:mm"
        val formatoDate = SimpleDateFormat(formatDate, Locale("es", "CO"))
        val formato = SimpleDateFormat("'Hora: ' HH:mm", Locale("es", "CO"))
        val date = formatoDate.parse(getDate)
        val timeFormat = formato.format(date)


            binding.tvDate.text = timeFormat
            binding.tvNameCollector.text = itemDetail.name_recolector
            binding.tvKgDetail.text = "${itemDetail.Cantidad} Kg"

            price.priceSplit(itemDetail.Precio.toInt()){
                binding.tvPrice.text = "Precio: ${it}"
            }

            if (itemDetail.Alimentacion == "yes") {
                binding.tvFeending.text = "Alimentacion: Si"
            } else {
                binding.tvFeending.text = "Alimentacion: No"
            }

            if (itemDetail.Estado == "active"){
                price.priceSplit(itemDetail.result.toInt()){
                    binding.tvPaid.text = "Total a Pagar: ${it}"
                }
            } else {
                price.priceSplit(itemDetail.result.toInt()){
                    binding.tvPaid.text = "Total Pagado: ${it}"
                }
            }


    }

}