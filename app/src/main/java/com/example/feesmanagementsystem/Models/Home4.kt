package com.example.feesmanagementsystem.Models

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.feesmanagementsystem.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

class Home4 : Fragment() {


    fun generateQRCode(data: String, studentName: String): Bitmap {
        val writer = QRCodeWriter()
        try {
//// RAZORPAY OPTION
//            // Get a reference to the Pay Fees button in your activity
//            val payButton: Button = findViewById(R.id.payment_button)
//
//// Set an OnClickListener on the Pay Fees button
//            payButton.setOnClickListener {
//                // Define the Razorpay payment link
//                val razorpayLink = "https://rzp.io/l/your_payment_link"
//
//                // Create a new intent to launch a web browser
//                val intent = Intent(Intent.ACTION_VIEW)
//                intent.data = Uri.parse(razorpayLink)
//
//                // Start the web browser activity to open the Razorpay payment link
//                startActivity(intent)
//            }
//// RAZORPAY  OVER
//
            val bitMatrix: BitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bmp.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
                }
            }
            return bmp
        } catch (e: WriterException) {
            e.printStackTrace()
        }
        return Bitmap.createBitmap(0, 0, Bitmap.Config.RGB_565)
    }

    private lateinit var studentNameEditText: EditText
    private lateinit var feesAmountEditText: EditText
    private lateinit var addFeesButton: Button
    private lateinit var feePaybtn: Button
    private lateinit var feesListView: ListView
    private lateinit var qrCodeImageView: ImageView

    private var feesList: MutableList<String> = mutableListOf()
    private lateinit var feesAdapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home4, container, false)

//// Check if the user is logged in
//        if (!isLoggedIn()) {
//            // If the user is not logged in, start the login activity
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        } else {
//            // If the user is logged in, display the student dashboard
//            setContentView(R.layout.activity_student_dashboard)
//
//            // Add your code for the student dashboard UI here
//        }
//    }
//
//    // Check if the user is logged in
//    private fun isLoggedIn(): Boolean {
//        // Replace this with your own logic to check if the user is logged in
//        return true // For this example, assume the user is always logged in
//    }
//}

        studentNameEditText = view.findViewById(R.id.student_name_edittext)
        feesAmountEditText = view.findViewById(R.id.fees_amount_edittext)
        addFeesButton = view.findViewById(R.id.add_fees_button)
        feesListView = view.findViewById(R.id.fees_listview)
        qrCodeImageView = view.findViewById(R.id.qr_code_imageview)

        feesAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,feesList)
        feesListView.adapter = feesAdapter

        addFeesButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val feesAmount = feesAmountEditText.text.toString()
            val feesEntry = "$studentName paid $feesAmount"

            feesList.add(feesEntry)
            feesAdapter.notifyDataSetChanged()
            studentNameEditText.text.clear()
            feesAmountEditText.text.clear()

            val qrCode = generateQRCode(feesAmount,studentName) // Generate QR code
            qrCodeImageView.setImageBitmap(qrCode) // Display QR code

//            Toast.makeText(this@Home4,"successfull",Toast.LENGTH_LONG).show()
        }

        return view
    }

}
