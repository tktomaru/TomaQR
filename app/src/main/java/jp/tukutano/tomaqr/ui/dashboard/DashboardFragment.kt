package jp.tukutano.tomaqr.ui.dashboard


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import jp.tukutano.tomaqr.databinding.FragmentDashboardBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val barcodeLauncher = registerForActivityResult(ScanContract()) { result ->
        if (result.contents != null) {
            binding.textViewResult.text = "${result.contents}"
        } else {
            binding.textViewResult.text = "キャンセルされました"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.buttonScan.setOnClickListener {
            val options = ScanOptions()
            options.setPrompt("QRコードをスキャンしてください")
            options.setBeepEnabled(true)
            options.setOrientationLocked(true)
            options.setBarcodeImageEnabled(true)
            barcodeLauncher.launch(options)
        }

        // コピー処理
        binding.buttonCopy.setOnClickListener {
            val text = binding.textViewResult.text.toString()
            if (text.isNotEmpty()) {
                val clipboard =
                    requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("QR読み取り結果", text)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(requireContext(), "クリップボードにコピーしました", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "コピーするテキストがありません", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}