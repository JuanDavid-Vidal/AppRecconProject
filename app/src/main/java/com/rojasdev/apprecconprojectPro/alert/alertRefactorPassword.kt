package com.rojasdev.apprecconprojectPro.alert

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.rojasdev.apprecconprojectPro.controller.animatedAlert
import com.rojasdev.apprecconprojectPro.controller.requireInput
import com.rojasdev.apprecconprojectPro.databinding.AlertRefactorPasswordBinding

class alertRefactorPassword(
var onClickListener: (String) -> Unit
): DialogFragment() {
    private lateinit var binding: AlertRefactorPasswordBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = AlertRefactorPasswordBinding.inflate(LayoutInflater.from(context))
        animatedAlert.animatedInit(binding.cvSettings)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        val myListInput = listOf(
            binding.hitCorreo,
        )

        binding.fbClose.setOnClickListener {
            dismiss()
        }

        binding.btReady.setOnClickListener {
            val require = requireInput.validate(myListInput,requireContext())
            if (require){
                dates()
                dismiss()
            }
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    private fun dates() {
        val email = binding.hitCorreo.text.toString()
        onClickListener(email)
    }
}


